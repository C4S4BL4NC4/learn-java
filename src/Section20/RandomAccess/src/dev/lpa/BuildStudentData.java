package dev.lpa;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuildStudentData {
    public static void build(String datFileName) {
        Path studentJSON = Path.of("students.json");
        String dataFile = datFileName + ".dat";
        Map<Long, Long> indexedIds = new LinkedHashMap<>();

        try {
            Files.deleteIfExists(Path.of(dataFile));
            String data = Files.readString(studentJSON);
            data = data.replaceFirst("^(\\[)", "")
                    .replaceFirst("(\\])$", "");
            var records = data.split(System.lineSeparator());
            System.out.println("# of records: " + records.length);

            long startingPos = 4 + (16L * records.length);

            Pattern pattern = Pattern.compile("studentId\":([0-9]+)");
            try (RandomAccessFile raf = new RandomAccessFile(dataFile, "rw")) {
                raf.seek(startingPos);
                for (var record : records) {
                    Matcher matcher = pattern.matcher(record);
                    if (matcher.find()) {
                        long id = Long.parseLong(matcher.group(1));
                        indexedIds.put(id, raf.getFilePointer());
                        raf.writeUTF(record);
                    }
                }
                writeIndex(raf, indexedIds);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeIndex(RandomAccessFile raf, Map<Long, Long> indexIds) {
        try {
            raf.seek(0);
            raf.writeInt(indexIds.size());
            for (var studentIdx : indexIds.entrySet()) {
                raf.writeLong(studentIdx.getKey());
                raf.writeLong(studentIdx.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
