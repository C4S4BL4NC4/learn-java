package dev.lpa;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class Challenge {
    public static void main(String[] args) {
        Path root = Path.of("public");
        Path indexFile = Path.of("index.txt");

        try (Stream<Path> paths = Files.walk(root);
             BufferedWriter bw = Files.newBufferedWriter(indexFile,
                     StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {

            paths.filter(Files::isDirectory).forEach(dirPath -> {
                try {
                    BasicFileAttributes attrs = Files.readAttributes(dirPath, BasicFileAttributes.class);
                    String dateCreated = DateTimeFormatter.ISO_INSTANT
                            .format(attrs.creationTime().toInstant());

                    String formatted = """
                            dirName:        %s
                            dateCreated:    %s
                            --------------------
                            """.formatted(dirPath.toString(), dateCreated);

                    bw.write(formatted);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}