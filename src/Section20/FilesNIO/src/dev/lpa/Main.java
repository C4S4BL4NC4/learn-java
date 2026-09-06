package dev.lpa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Path pathSmall = Path.of("files/small_file.txt");
        Path pathBig = Path.of("files/big_file.txt");
        readFromSmallTxtFile(pathSmall);
        readFromBigTxtFile(pathBig);
        writeSmallTxtFile(pathSmall);
        writeBigTxtFile(pathBig);
    }

    private static void readFromSmallTxtFile(Path filePath) {
        try {
            Files.readAllLines(filePath).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readFromBigTxtFile(Path filePath) {
        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeSmallTxtFile(Path filePath) {
        try {
            Files.writeString(filePath, "\n" + Instant.now().toString(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeBigTxtFile(Path filePath) {
        try (BufferedWriter bw = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            bw.write("\n" + Instant.now());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
