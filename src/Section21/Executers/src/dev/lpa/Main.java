package dev.lpa;

import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {

    public static void main(String[] args) {

        var multiExecuter = Executors.newCachedThreadPool();
        try {
            multiExecuter.execute(
                    () -> Main.sum(1, 10, 1, "red")
            );

            multiExecuter.execute(
                    () -> Main.sum(10, 100, 10, "green")
            );

            multiExecuter.execute(
                    () -> Main.sum(2, 20, 2, "blue")
            );

            multiExecuter.execute(
                    () -> Main.sum(1, 10, 1, "yellow")
            );

            multiExecuter.execute(
                    () -> Main.sum(10, 100, 10, "cyan")
            );

            multiExecuter.execute(
                    () -> Main.sum(2, 20, 2, "purple")
            );
        } finally {
            multiExecuter.shutdown();
        }
    }

    public static void fixedmain(String[] args) {

        int count = 6;
        var execService = Executors.newFixedThreadPool(
                count, new ColorThreadFactory()
        );

        for (int i = 0; i < count; i++) {
            execService.execute(Main::countDown);
        }
        
        execService.shutdown();
    }

    public static void singlethreadmain(String[] args) {

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

    public static void sum(int start, int end, int hop, String colorString) {
        var threadColor = ThreadColor.ANSI_RESET;
        try {
            threadColor = ThreadColor.valueOf("ANSI_" + colorString.toUpperCase());
        } catch (IllegalArgumentException e) {
           // Ignore
        }
        var color = threadColor.color();
        int sum = 0;
        for (int i = 0; i <= end ; i+=hop) {
            sum+=i;
        }
        System.out.println(color + Thread.currentThread().getName() + ", " + colorString + " " + sum);
    }

    static class ColorThreadFactory implements ThreadFactory {
        private String threadName;
        private int colorValue = 1;

        public ColorThreadFactory() {

        }

        public ColorThreadFactory(ThreadColor threadColor) {
            this.threadName = threadColor.name();
        }

        @Override
        public Thread newThread(Runnable r) {
            var name = threadName;
            if (name == null) {
                name = ThreadColor.values()[colorValue].name();
            }

            if (++colorValue > (ThreadColor.values().length - 1)) {
                colorValue = 1;
            }

            return new Thread(r, name);
        }
    }
}
