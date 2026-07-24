import dev.lpa.model.LPAStudent;
import dev.lpa.model.Student;
import dev.lpa.model.TypeErasure;
import dev.lpa.util.QueryList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            Student s = new Student();
            students.add(s);
        }

        List<LPAStudent> LPAStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            LPAStudent s = new LPAStudent();
            LPAStudents.add(s);
        }
//        printList(students);
//        System.out.println();
//        printList(LPAStudents);
//        System.out.println();
//        printMoreLists(LPAStudents);
//        System.out.println();
//        TypeErasure.testList(List.of(1,2,3,4));
//        TypeErasure.testList(List.of("Alex", "Rock", "Pawn"));
        var queryList = new QueryList<>(LPAStudents);
        var matches = queryList.getMatches("yearStarted", "2015");
        printMoreLists(matches);
    }

    public static void printMoreLists(List<? extends Student> students) {
        for (var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
    }

    public static <T> void printList(List<T> students) {
        for (T student : students) {
            System.out.println(student);
        }
    }

//    public static void printList(List<?> students) {
//        for (var student : students) {
//            System.out.println(student);
//        }
//    }
}
