package dev.lpa;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        int k = 10;

        Runnable r1 = () -> {
            // Even thread
            for (int i = 1; i <= k; i++) {
                if (i % 2 == 0) {
                    System.out.println("t1 - " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Runnable r2 = () -> {
            // Odd thread
            for (int i = 1; i <= k; i++) {
                if (i % 2 > 0) {
                    System.out.println("t2 - " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        var t1 = new Thread(r1, "t1");
        var t2 = new Thread(r2, "t2");

        t1.start();
        t2.start();

        try {
            Thread.sleep(3000);
            t1.interrupt();
            Thread.sleep(1000);
            t2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
