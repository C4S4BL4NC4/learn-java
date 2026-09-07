package dev.lpa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            var content = Files.readString(Path.of("article.txt"));
            var sanitized = content.replaceAll("\\p{Punct}", "");
            var finalized = Arrays.stream(sanitized.split("\\s+"))
                    .map(String::toLowerCase)
                    .map(String::trim)
                    .filter(s -> s.length() > 5)
                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

            finalized.entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .limit(10)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
