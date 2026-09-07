package dev.lpa;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Challenge {
    public static void main(String[] args) {
        System.out.println("Main.main");
        Path startingPath = Path.of(".");
        FileVisitor<Path> statsVisitor = new StatsVisitor(Integer.MAX_VALUE);
        try {
            Files.walkFileTree(startingPath, statsVisitor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static class StatsVisitor implements FileVisitor<Path> {

        public static final String DIR_CNT = "DirCount";
        public static final String FILE_CNT = "FileCount";
        public static final String FILE_SIZE = "FileSize";

        private final Map<Path, Map<String, Long>> folderSizes = new LinkedHashMap<>();
        private int initialCount;
        private Path initialPath = null;
        private int printLevel;

        public StatsVisitor(int printLevel) {
            this.printLevel = printLevel;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(file);
            Objects.requireNonNull(attrs);

            var parentMap = folderSizes.get(file.getParent());
            if (parentMap != null) {
                long fileSize = attrs.size();
                parentMap.merge(FILE_SIZE, fileSize, (o, n) -> o += n);
                parentMap.merge(FILE_CNT, 1L, Math::addExact);
                return FileVisitResult.CONTINUE;
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            Objects.requireNonNull(file);
            if (exc != null) {
                System.out.println(exc.getClass().getSimpleName() + ": " + file);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(dir);
            Objects.requireNonNull(attrs);

            if (initialPath == null) {
                initialPath = dir;
                initialCount = dir.getNameCount();
            } else {
                int relativeLevel = dir.getNameCount() - initialCount;
                if (relativeLevel == 1) {
                    folderSizes.clear();
                }
                folderSizes.put(dir, new HashMap<>());
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            Objects.requireNonNull(dir);
            if (dir.equals(initialPath)) {
                return FileVisitResult.TERMINATE;
            }
            int relativeLevel = dir.getNameCount() - initialCount;
            if (relativeLevel == 1) {
                folderSizes.forEach((key, val) -> {
                    int level = key.getNameCount() - initialCount - 1;
                    if (level < printLevel) {
                        long size = val.getOrDefault(FILE_SIZE, 0L);
                        System.out.printf("%s[%s] - %,d bytes, %d files, %d folders.%n ",
                                "\t".repeat(level),
                                key.getFileName(),
                                size,
                                val.getOrDefault(FILE_CNT, 0L),
                                val.getOrDefault(DIR_CNT, 0L));
                    }

                });
            } else {
                var parentMap = folderSizes.get(dir.getParent());
                var childMap = folderSizes.get(dir);

                long folderCount = childMap.getOrDefault(DIR_CNT, 0L);
                long fileSize = childMap.getOrDefault(FILE_SIZE, 0L);
                long fileCount = childMap.getOrDefault(FILE_CNT, 0L);

                parentMap.merge(DIR_CNT, folderCount + 1, (o, n) -> o += n);
                parentMap.merge(FILE_SIZE, fileSize, Math::addExact);
                parentMap.merge(FILE_CNT, fileCount, Math::addExact);
            }
            return FileVisitResult.CONTINUE;
        }
    }


}
