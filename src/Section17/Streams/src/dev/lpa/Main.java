package dev.lpa;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");

        var bingoPool = new ArrayList<String>(75);

        int start = 1;
        for (char c : "BINGO".toCharArray()) {
            for (int i = start; i < (start + 15); i++) {
                bingoPool.add("" + c + i);
//                System.out.println("" + c + i);
            }
            start += 15;
        }

        Collections.shuffle(bingoPool);
        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }

        System.out.println("----------------------------------------");

        var tempStream = bingoPool.stream()
                .limit(15)
                .filter(s -> s.indexOf('G') == 0 || s.indexOf('O') == 0)
                .map(s -> s.charAt(0) + "-" + s.substring(1))
                .sorted();
//                .forEach(s -> System.out.println(s + " "));
        tempStream.forEach(s -> System.out.println(s + " "));

        System.out.println("----------------------------------------");

        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }

        System.out.println("----------------------------------------");

        String[] strings = {"One", "Two", "Three"};
        var firstStream = Arrays.stream(strings)
                .sorted(Comparator.reverseOrder());
//                .forEach(System.out::println);

        var secondStream = Stream.of("Four", "Five", "Six")
                .map(String::toUpperCase);
//                .forEach(System.out::println);

        Stream.concat(secondStream, firstStream)
                .map(s -> s.charAt(0) + " - " + s)
                .forEach(System.out::println);


        System.out.println("----------------------------------------");

        Map<Character, int[]> myMap = new LinkedHashMap<>();
        int bingoIndex = 1;
        for (var c : "BINGO".toCharArray()) {
            int[] numbers = new int[15];
            int labelNo = bingoIndex;

            Arrays.setAll(numbers, i -> i + labelNo);
            myMap.put(c, numbers);
            bingoIndex += 15;
        }

        myMap.entrySet()
                .stream()
                .map(e -> Arrays.toString(e.getValue())
                        + " has range: "
                        + e.getValue()[0]
                        + " - "
                        + e.getValue()[e.getValue().length - 1])
                .forEach(System.out::println);
        
        Random random = new Random();
        Stream.generate(() -> random.nextInt(2))
                .limit(20)
                .forEach(s -> System.out.print(s + " "));
    }
}
