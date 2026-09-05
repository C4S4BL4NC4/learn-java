package dev.lpa;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        System.out.println(format("%s %s %s", "My name", "is", "ironman"));

        String paragraph = """
                Double, double toil and trouble;
                Fire burn and caldron bubble.
                Fillet of a fenny snake,
                In the caldron boil and bake;
                Eye of newt and toe of frog,
                Wool of bat and tongue of dog,
                Adder's fork and blind-worm's sting,
                Lizard's leg and howlet's wing,
                For a charm of powerful trouble,
                Like a hell-broth boil and bubble.
                """;
        paragraph = paragraph.replaceAll("[A-Za-z]+ble", "[GRUB]");
        System.out.println(paragraph);

        System.out.println("-----------------------------");

        Scanner scanner = new Scanner(paragraph);
        System.out.println("Old delimiter: " + scanner.delimiter());
        scanner.useDelimiter("\\R");
        System.out.println("New delimiter: " + scanner.delimiter());
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        scanner.close();

        System.out.println("---------------------------");

        String helloWorld = "Hello, World!";
        System.out.println(helloWorld.matches("Hello, World!"));

        String bike = "The bike is red.";
        System.out.println(bike.matches("^[A-Z].*\\."));

        System.out.println("---------------------------");

        String pattern = "^[A-Z][\\p{all}]+[.?!]$";

        for (var sen : List.of(
                "The bike is red, and has flat tires.",
                "I love being a new L.P.A. student!",
                "Hello, friends and family: Welcome!",
                "How are you, Mary?")) {
            System.out.println(sen + " : " + sen.matches(pattern));
        }
    }

    private static String format(String regexp, String... args) {
        int index = 0;
        while (regexp.contains("%s")) {
            regexp = regexp.replaceFirst("%s", args[index++]);
        }
        return regexp;
    }
}
