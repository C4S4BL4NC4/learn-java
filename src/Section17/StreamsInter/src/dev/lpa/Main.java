package dev.lpa;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        IntStream.iterate((int) 'A', i -> i <= (int) 'z', i -> i + 1)
//                .skip(5)
                .dropWhile(i -> i <= 'E')
                .filter(Character::isAlphabetic)
                .forEach(s -> System.out.printf("%c%n", s));
    }
}
