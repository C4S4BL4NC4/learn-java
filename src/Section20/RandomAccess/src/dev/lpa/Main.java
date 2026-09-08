package dev.lpa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Long, Long> indexIds = new LinkedHashMap<>();
    private static int recordsInFile = 0;

    public static void main(String[] args) {
        System.out.println("Main.main");
//        BuildStudentData.build("studentData");
        try (var raf = new RandomAccessFile("studentData.dat", "r")) {
            loadIndex(raf, 0);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter records id or 0 to quit: ");
            while (scanner.hasNext()) {
                long studentId = Long.parseLong(scanner.next());
                if (studentId < 1) {
                    break;
                }
                raf.seek(indexIds.get(studentId));
                String targetedRecord = raf.readUTF();
                System.out.println(targetedRecord);
                System.out.println("Enter records id or 0 to quit: ");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadIndex(RandomAccessFile raf, int indexPosition) throws IOException {
        try {
            raf.seek(indexPosition);
            recordsInFile = raf.readInt();
            System.out.println(recordsInFile);
            for (int i = 0; i < recordsInFile; i++) {
                indexIds.put(raf.readLong(), raf.readLong());

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
