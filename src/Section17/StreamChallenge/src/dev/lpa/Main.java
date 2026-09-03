package dev.lpa;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        int seed = 1;
        var streamB = Stream.iterate(seed, i -> i <= 15, i -> i + 1).map(i -> "B" + i);
        streamB.forEach(System.out::println);

        seed += 15;
        var streamI = Stream.iterate(seed, i -> i <= 30, i -> i + 1).limit(15).map(i -> "I" + i);
        streamI.forEach(System.out::println);

        seed += 15;
        var streamN = Stream.iterate(seed, i -> i <= 45, i -> i + 1).limit(15).map(i -> "N" + i);
        streamN.forEach(System.out::println);
    }
}
