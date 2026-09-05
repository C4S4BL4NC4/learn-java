package dev.lpa;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        useFile("testFile.txt");
        usePath("testPath.txt");
    }

    private static void useFile(String fileName) {
        File file = new File(fileName);
        boolean fileExists = file.exists();

        System.out.printf("File '%s' %s%n", fileName, fileExists ? "exists." : "does not exist.");
        if (fileExists) {
            System.out.println("Deleting File: " + fileName);
            fileExists = !file.exists();
        }
        if (!fileExists) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Created File: " + fileName);
            if (file.canWrite()) {
                System.out.println("Could write to file here");
            }
        }
    }

    private static void usePath(String fileName) {
        Path path = Path.of(fileName);
        boolean fileExists = Files.exists(path);

        System.out.printf("File '%s' %s%n", fileName, fileExists ? "exists." : "does not exist.");
        if (fileExists) {
            System.out.println("Deleting File: " + fileName);
            try {
                Files.delete(path);
                fileExists = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!fileExists) {
            try {
                Files.createFile(path);
                System.out.println("Created File: " + fileName);
                if (Files.isWritable(path)) {
                    System.out.println("Could write to file here");
                    Files.writeString(path, """
                            My name is Walter White Yo
                            """);
                }
                System.out.println("-------- I Can Read too --------");
                Files.readAllLines(path).forEach(System.out::println);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
