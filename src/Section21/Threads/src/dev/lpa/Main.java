package dev.lpa;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main.main");

        var currentThread = Thread.currentThread();
        //        System.out.println("Current thread: " + currentThread);
        printThreadState(currentThread);

        currentThread.setName("MainThread");
        currentThread.setPriority(Thread.MAX_PRIORITY);
        printThreadState(currentThread);

        var customThread = new CustomThread();
        //        customThread.run(); // Synchronously run thread (run code on the same thread)
        customThread.start(); // Asynchronously run thread (creates a new entire thread)

        Runnable threadTask = () -> {
            for (int i = 1; i <= 8; i++) {
                System.out.print(" 2 ");
                try {
                    TimeUnit.MILLISECONDS.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread myThead = new Thread(threadTask);
        myThead.start();

        for (int i = 1; i <= 3; i++) {
            System.out.print(" 0 ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //        var t1 = new CustomThread();
        //        var t2 = new CustomThread();
        //        var t3 = new CustomThread();
        //        var t4 = new CustomThread();
        //
        //        t1.start();
        //        t2.start();
        //        t3.start();
        //        t4.start();
    }

    public static void printThreadState(Thread thread) {
        System.out.println("-----------------------------");
        System.out.println("thread.getId() = " + thread.getId());
        System.out.println("thread.getName() = " + thread.getName());
        System.out.println("thread.getPriority() = " + thread.getPriority());
        System.out.println("thread.getState() = " + thread.getState());
        System.out.println("thread.getThreadGroup() = " + thread.getThreadGroup());
        System.out.println("thread.isAlive() = " + thread.isAlive());
        System.out.println("-----------------------------");
    }
}
