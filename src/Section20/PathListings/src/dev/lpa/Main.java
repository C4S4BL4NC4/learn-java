package dev.lpa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
//        Path path = Path.of("rouge/lmao/ev/files/testing.txt");
//        printPathInfo(path);
//        logStatement(path);
//        extraInfo(path);
        Path path = Path.of("");
        System.out.println("cwd: " + path.toAbsolutePath());

        try (Stream<Path> paths = Files.list(path)) {
            paths
                    .map(Main::listDir)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n=================WALK PATH=================");

        try (Stream<Path> paths = Files.walk(path, Integer.MAX_VALUE)) {
            paths
                    .filter(Files::isRegularFile)
                    .map(Main::listDir)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n=================FIND PATH=================");

        try (Stream<Path> paths = Files.find(path, Integer.MAX_VALUE,
                (p, attr) -> attr.isRegularFile() && attr.size() > 300
        )) {
            paths
                    .map(Main::listDir)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n=================DIRECTORY STREAM WITH GLOB=================");
        path = path.resolve(".idea");
        try (var dirs = Files.newDirectoryStream(path, "*.xml")) {
            dirs.forEach(d -> System.out.println(Main.listDir(d)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("\n=================DIRECTORY STREAM WITH LAMBDA=================");

        try (var dirs = Files.newDirectoryStream(path,
                p -> p.getFileName().toString().endsWith(".xml")
                        && Files.isRegularFile(p)
                        && Files.size(p) > 1000)) {
            dirs.forEach(d -> System.out.println(Main.listDir(d)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String listDir(Path path) {
        boolean isDir = Files.isDirectory(path);
        try {
            FileTime dateField = Files.getLastModifiedTime(path);
            LocalDateTime localDT = LocalDateTime.ofInstant(
                    dateField.toInstant(), ZoneId.systemDefault()
            );
            return "%tD %tT %-5s %12s %s".formatted(
                    localDT,
                    localDT,
                    (isDir ? "<DIR>" : ""),
                    (isDir ? "" : Files.size(path)),
                    path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printPathInfo(Path path) {
        System.out.println("Path: " + path);
        System.out.println("fileName: " + path.getFileName().toString());
        System.out.println("Parent: " + path.getParent());
        Path absolutePath = path.toAbsolutePath();
        System.out.println("Absolute path: " + absolutePath);
        System.out.println("Absolute Path root: " + absolutePath.getRoot());
        System.out.println("Path root: " + path.getRoot());
        System.out.println("Path is absolute: " + path.isAbsolute());
        System.out.println(absolutePath.getRoot());
//        int i = 1;
//        var it = path.toAbsolutePath().iterator();
//        while (it.hasNext()) {
//            System.out.println(".".repeat(i++) + " " + it.next());
//        }
        System.out.println("----------------------------------------");
        System.out.println(absolutePath.getRoot());
        int pathParts = absolutePath.getNameCount();
        for (int i = 0; i < pathParts; i++) {
            System.out.println(".".repeat(i + 1) + " " + absolutePath.getName(i));
        }

    }

    private static void logStatement(Path path) {
        try {
            Path parent = path.getParent();
            if (!Files.exists(parent)) {
                Files.createDirectories(parent);
            }
            Files.writeString(path, Instant.now() + ": hello world\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Success!");
            System.out.println("----------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extraInfo(Path path) {
        try {
            var atts = Files.readAttributes(path, "*");
            atts.entrySet().forEach(System.out::println);
            System.out.println(Files.probeContentType(path));
        } catch (IOException e) {
            System.out.println("Problem reading file: " + e.getMessage());
        }
    }
}
