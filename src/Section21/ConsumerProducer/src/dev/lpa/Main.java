package dev.lpa;

import java.util.Random;

class MessageRepository {
    private String message;
    private boolean hasMessage = false;

    public synchronized String readMessage() {
        while (!hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        hasMessage = false;
        notifyAll();
        return message;
    }

    public synchronized void writeMessage(String message) {
        while (hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        hasMessage = true;
        notifyAll();
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
