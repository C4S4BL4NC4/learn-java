package dev.lpa;

import dev.lpa.student.Course;
import dev.lpa.student.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");

        var header = """
                Student Id,Country Code,Enrolled Year,Age,Gender,\
                Experienced,Course Code,Engagement Month,Engagement Year,\
                Engagement Type""";

        var jmc = new Course("JMC", "Java Masterclass");
        var pymc = new Course("PYC", "Python Masterclass");
        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(10)
                .toList();

        Path path = Path.of("students.csv");
        try {
            Files.writeString(path, header);
            for (Student student : students) {
                Files.write(path, student.getEngagementRecords(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Buffered Writer
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("take2.csv"))) {
            writer.write(header);
            writer.newLine();
            for (Student student : students) {
                for (var record : student.getEngagementRecords()) {
                    writer.write(record.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // File Writer
        try (FileWriter writer = new FileWriter("take3.csv")) {
            writer.write(header);
            writer.write(System.lineSeparator());
            for (Student student : students) {
                for (var record : student.getEngagementRecords()) {
                    writer.write(record.toString());
                    writer.write(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Print Writer
        try (PrintWriter writer = new PrintWriter("take4.csv")) {
            writer.println(header);
            for (Student student : students) {
                for (var record : student.getEngagementRecords()) {
                    writer.println(record);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // FORMATING TO TEXT FILE
        try (PrintWriter writer = new PrintWriter("formatted_data.txt")) {
            writer.println(header);
            for (Student student : students) {
                for (var record : student.getEngagementRecords()) {
                    var recordData = record.split(",");
                    writer.printf("%-12d%-5s%2d%4d%3d%-1s".formatted(
                            student.getStudentId(),
                            student.getCountry(),
                            student.getEnrollmentYear(),
                            student.getEnrollmentMonth(),
                            student.getEnrollmentAge(),
                            student.getGender()
                    ));
                    writer.printf("%-1s", (student.hasExperience() ? 'Y' : 'N'));
                    writer.format("%-3s%10.2f%-10s%-4s%-30s",
                            recordData[7],
                            student.getPercentComplete(recordData[7]),
                            recordData[8],
                            recordData[9],
                            recordData[10]
                    );
                    writer.println();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
