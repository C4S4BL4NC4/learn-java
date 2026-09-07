package dev.lpa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
//        File oldFile = new File("students.json");
//        File newFile = new File("student-activity.json");
//        if (oldFile.exists()) {
//            oldFile.renameTo(newFile);
//            System.out.println("Successfully renamed!");
//        } else {
//            System.out.println("File doesn't exist!");
//        }
//
//        Path oldPath = oldFile.toPath();
//        Path newPath = newFile.toPath();

//        Path oldPath = Path.of("students.json");
//        Path newPath = Path.of("files/student-acitivty.json");
//
//        try {
//            Files.createDirectories(newPath.subpath(0, newPath.getNameCount() - 1));
//            Files.move(oldPath, newPath);
//            System.out.println(oldPath + " -> " + newPath);
//            System.out.println("Path renamed successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Path fileDir = Path.of("files");
        Path resourceDir = Path.of("resources");
        try {
//            Files.move(fileDir, resourceDir);
//            Files.copy(fileDir, resourceDir);
            recursiveDelete(resourceDir);
            recursiveCopy(fileDir, resourceDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void recursiveCopy(Path source, Path target) throws IOException {
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        if (Files.isDirectory(source)) {
            try (var children = Files.list(source)) {
                children.toList().forEach(
                        p -> {
                            try {
                                Main.recursiveCopy(p, target.resolve(p.getFileName()));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private static void recursiveDelete(Path target) throws IOException {
        if (Files.isDirectory(target)) {
            try (var children = Files.list(target)) {
                children.toList().forEach(
                        p -> {
                            try {
                                Main.recursiveDelete(p);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Files.deleteIfExists(target);
    }
}
