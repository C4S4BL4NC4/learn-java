package dev.lpa;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MessageRepository {
    private final Lock lock = new ReentrantLock();
    private String message;
    private boolean hasMessage = false;

    public String readMessage() {
        if (lock.tryLock()) {
            try {
                while (!hasMessage) {

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                hasMessage = false;
            } finally {
                System.out.println("**Read blocked");
                lock.unlock();
            }
        } else {
            hasMessage = false;
        }

        return message;
    }

    public void writeMessage(String message) {
        if (lock.tryLock()) {
            try {
                while (hasMessage) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                hasMessage = true;
            } finally {
                lock.unlock();
            }

        } else {
            System.out.println("**Write blocked");
            hasMessage = true;
        }
        this.message = message;
    }
}


class MessageWriter implements Runnable {

    private final String text = """
            Humpty Dumpty sat on a wall,
            Humpty Dumpty had a great fall,
            All the king's horses and all the king's men,
            Couldn't put Humpty Dumpty together again.
            """;
    private MessageRepository repository;

    public MessageWriter(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] lines = text.split("\n");

        for (int i = 0; i < lines.length; i++) {
            repository.writeMessage(lines[i]);
            try {
                Thread.sleep(random.nextInt(500, 2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        repository.writeMessage("Finished");
    }
}

class MessageReader implements Runnable {
    private final MessageRepository repository;

    public MessageReader(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {
        Random random = new Random();
        String latestMessage = "";
        do {
            try {
                Thread.sleep(random.nextInt(500, 2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            latestMessage = repository.readMessage();
            System.out.println(latestMessage);
        } while (!latestMessage.equals("Finished"));
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");

        var repository = new MessageRepository();
        var reader = new Thread(new MessageReader(repository));
        var writer = new Thread(new MessageWriter(repository));

        reader.start();
        writer.start();

    }
}
