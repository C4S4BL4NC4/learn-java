package dev.lpa;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        IntStream.iterate((int) 'A', i -> i <= (int) 'z', i -> i + 1)
                .filter(Character::isAlphabetic)
                .map(Character::toUpperCase)
                .distinct()
//                .skip(5)
//                .dropWhile(i -> i <= 'E') // Stops when predicate becomes false
//                .takeWhile(i -> i < 'a')
                .forEach(s -> System.out.printf("%c%n", s));

        Random random = new Random();

        Stream.generate(() -> random.nextInt((int) 'A', (int) 'Z' + 1))
                .limit(50)
                .distinct()
                .sorted()
                .forEach(c -> System.out.printf("%c%n", c));
    }
}
