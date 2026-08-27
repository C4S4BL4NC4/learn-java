package dev.lpa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");

        var bobsNotes = new StringBuilder();
        var billsNotes = new StringBuilder("I struggle with generics");

        var bob = new Student("Bob", bobsNotes);
        var bill = new Student("Bill", billsNotes);

        var students = new ArrayList<>(List.of(bob, bill));
        var firstCopyStudents = new ArrayList<>(students); // Shallow Copy     +    Mutable
        var secondCopyStudents =
                List.copyOf(students);                     // Shallow Copy     +    Immutable
        var thirdCopyStudents =
                Collections.unmodifiableList(students);    // Read only        +    Immutable

        firstCopyStudents.add(new Student("Alex", new StringBuilder("")));
//        secondCopyStudents.add(new Student("Rocky", new StringBuilder("")));
//        thirdCopyStudents.add(new Student("Bobby", new StringBuilder("")));


        bobsNotes.append("appending bobs notes");
        students.forEach(System.out::println);
        System.out.println("------------------------------------");
        firstCopyStudents.forEach(System.out::println);
        System.out.println("------------------------------------");
        secondCopyStudents.forEach(System.out::println);
        System.out.println("------------------------------------");
        thirdCopyStudents.forEach(System.out::println);
        System.out.println("------------------------------------");

    }
}
