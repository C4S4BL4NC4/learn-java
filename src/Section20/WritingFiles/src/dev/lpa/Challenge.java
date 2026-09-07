package dev.lpa;

import dev.lpa.student.Course;
import dev.lpa.student.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Stream;

public class Challenge {
    public static void main(String[] args) {
        System.out.println("Challenge.main");

        var jmc = new Course("JMC", "Java Masterclass");
        var pymc = new Course("PYC", "Python Masterclass");
        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(1000)
                .toList();

        try (PrintWriter writer = new PrintWriter("students.json")) {
            writer.println("{");
            writer.println("\t\"students\": [");
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                String comma = (i < students.size() - 1) ? "," : "";
                writer.printf("\t{\n\t\t\"id\": %d,\n\t\t\"country\": \"%s\",\n\t\t\"enrollmentYear\": %d,\n\t\t\"enrollmentMonth\": %d,\n\t\t\"age\": %d,\n\t\t\"gender\": \"%s\"\n\t}%s\n".formatted(
                        student.getStudentId(),
                        student.getCountry(),
                        student.getEnrollmentYear(),
                        student.getEnrollmentMonth(),
                        student.getEnrollmentAge(),
                        student.getGender(),
                        comma
                ));
            }
            writer.println("\t]");
            writer.println("}");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
