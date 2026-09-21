package dev.lpa;

import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        List<Callable<Integer>> tasks = List.of(
                () -> Main.sum(1, 10, 1, "red"),
                () -> Main.sum(2, 20, 2, "green"),
                () -> Main.sum(10, 100, 10, "blue")
        );
        var multiExecuter = Executors.newCachedThreadPool();
        try {
            // .invokeAny returns the first task that finishes.
            var results = multiExecuter.invokeAll(tasks);
            for (var result : results) {
                System.out.println(result.get(500, TimeUnit.SECONDS));
            }
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        } finally {
            multiExecuter.shutdown();
        }
    }

    public static void cachedmain(String[] args) {

        // Submit for runnable and callables
        // Execute for runnable only
        var multiExecuter = Executors.newCachedThreadPool();
        try {
            var redValue = multiExecuter.submit(
                    () -> Main.sum(1, 10, 1, "red")
            );

            var greenValue = multiExecuter.submit(
                    () -> Main.sum(10, 100, 10, "green")
            );

            var blueValue = multiExecuter.submit(
                    () -> Main.sum(2, 20, 2, "blue")
            );

            try {
                System.out.println(redValue.get(500, TimeUnit.SECONDS));
                System.out.println(greenValue.get(500, TimeUnit.SECONDS));
                System.out.println(blueValue.get(500, TimeUnit.SECONDS));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

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

    public static int sum(int start, int end, int hop, String colorString) {
        var threadColor = ThreadColor.ANSI_RESET;
        try {
            threadColor = ThreadColor.valueOf("ANSI_" + colorString.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Ignore
        }
        var color = threadColor.color();
        int sum = 0;
        for (int i = 0; i <= end; i += hop) {
            sum += i;
        }
        System.out.println(color + Thread.currentThread().getName() + ", " + colorString + " " + sum);
        return sum;
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
