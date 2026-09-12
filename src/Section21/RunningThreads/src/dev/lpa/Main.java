package dev.lpa;

public class Main {

    public static void main(String[] args) {
        System.out.println("Thread is Running...");
        try {
            System.out.println("Main thread is paused for one second...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " should take 10 dots to run.");
            for (int i = 0; i < 10; i++) {
                System.out.print(". ");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("\nWhoops! " + threadName + " interrupted.");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println("\n" + threadName + " completed.");
        });

        Thread installThread = new Thread(
                () -> {
                    try {
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(300);
                            System.out.println("Installation " + i + " is completed.");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                "InstallThread"
        );

        Thread threadMonitor = new Thread(() -> {
            var nowStamp = System.currentTimeMillis();
            while (thread.isAlive()) {
                try {
                    Thread.sleep(1000);

                    if (System.currentTimeMillis() - nowStamp > 8000) {
                        thread.interrupt();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(thread.getName() + " starting");
        thread.start();
        threadMonitor.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!thread.isInterrupted()) {
            installThread.start();
        } else {
            System.out.println(
                    "Previous thread has been interrupted, " + installThread.getName() + " can't run."
            );
        }
    }
}
