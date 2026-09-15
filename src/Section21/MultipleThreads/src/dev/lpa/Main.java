package dev.lpa;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        var purpleWatch = new StopWatch(TimeUnit.SECONDS);
        var greenWatch = new StopWatch(TimeUnit.SECONDS);
        var redWatch = new StopWatch(TimeUnit.SECONDS);

        Thread purple = new Thread(() -> purpleWatch.countDown(7), ThreadColor.ANSI_PURPLE.name());
        Thread green = new Thread(greenWatch::countDown, ThreadColor.ANSI_GREEN.name());
        Thread red = new Thread(redWatch::countDown, ThreadColor.ANSI_RED.name());

        purple.start();
        green.start();
        red.start();
    }
}

class StopWatch {
    private int i;
    private TimeUnit timeUnit;

    public StopWatch(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public void countDown() {
        countDown(5);
    }

    public void countDown(int unitCount) {

        String threadName = Thread.currentThread().getName();

        ThreadColor threadColor = ThreadColor.ANSI_RESET;
        try {
            threadColor = ThreadColor.valueOf(threadName.toUpperCase());

        } catch (IllegalArgumentException e) {
            // Bad color
        }

        String color = threadColor.color();
        for (i = unitCount; i > 0; i--) {
            try {
                timeUnit.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s%s Thread: i %d%n", color, threadName, i);
        }
    }
}
