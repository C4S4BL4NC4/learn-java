package dev.lpa;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {

    public static void main(String[] args) {

        var redExecutor = Executors.newSingleThreadExecutor(
                new ColorThreadFactory(ThreadColor.ANSI_RED)
        );
        redExecutor.execute(Main::countDown);
        redExecutor.shutdown();

        var greenExecutor = Executors.newSingleThreadExecutor(
                new ColorThreadFactory(ThreadColor.ANSI_GREEN)
        );
        greenExecutor.execute(Main::countDown);
        greenExecutor.shutdown();

        var blueExecutor = Executors.newSingleThreadExecutor(
                new ColorThreadFactory(ThreadColor.ANSI_BLUE)
        );
        
        redExecutor.execute(Main::countDown);
        redExecutor.shutdown();

        greenExecutor.execute(Main::countDown);
        greenExecutor.shutdown();

        blueExecutor.execute(Main::countDown);
        blueExecutor.shutdown();
    }

    public static void notmain(String[] args) {
        Thread red = new Thread(Main::countDown, ThreadColor.ANSI_RED.name());
        Thread green = new Thread(Main::countDown, ThreadColor.ANSI_GREEN.name());
        Thread blue = new Thread(Main::countDown, ThreadColor.ANSI_BLUE.name());

        red.start();
        try {
            red.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        green.start();
        try {
            green.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        blue.start();
        try {
            blue.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("All threads finished!");
    }

    public static void countDown() {
        String threadName = Thread.currentThread().getName();
        var threadColor = ThreadColor.ANSI_RESET;
        try {
            threadColor = ThreadColor.valueOf(threadName.toUpperCase());

        } catch (IllegalArgumentException e) {
            // Error code
        }
        var color = threadColor.color();
        for (int i = 20; i >= 0; i--) {
            System.out.println(color + " " + threadName.replace("ANSI_", "") + " " + i);
        }
    }

    static class ColorThreadFactory implements ThreadFactory {
        private final String threadName;

        public ColorThreadFactory(ThreadColor threadColor) {
            this.threadName = threadColor.name();
        }

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, threadName);
        }
    }
}
