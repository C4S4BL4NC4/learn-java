package dev.lpa.lamba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaExpr {
    record Person (String name, String lastName){

        @Override
        public String toString() {
            return name + " " + lastName;
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new LambdaExpr.Person("Jonas", "Schmedtmann"),
                new Person("Rocky", "Rock"),
                new Person("Peter", "Parker"),
                new Person("Bruce", "Wayne"),
                new Person("Able", "Adams"),
                new Person("Alisson", "Becker")
        ));
//        System.out.println(people);
        // Anonymous Class
        var comparatorLastName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        };
        people.sort(comparatorLastName);
//        System.out.println(people);

        // Lambda Expression
        people.sort((o1, o2) -> o2.lastName.compareTo(o1.lastName));
//        System.out.println(people);

        people.forEach((p) -> System.out.println(p));
    }
}
