package dev.lpa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");

        List<Person> people = new ArrayList<>(List.of(
                new Person("Mr", "Potatohead"),
                new Person("Van", "Hellsing"),
                new Person("Master", "Chief")
        ));

        var comparatorLastName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName().compareTo(o2.lastName());
            }
        };

//        people.sort(comparatorLastName);
        people.sort((o1, o2) -> o1.lastName().compareTo(o2.lastName()));

        System.out.println(people);

        int result = calculator(Integer::sum, 5, 2);
        int result2 = calculator(Integer::divideUnsigned, 5, 2);
        String result3 = calculator((a, b) -> a.toUpperCase(Locale.ROOT) + " " + b.toUpperCase(Locale.ROOT), "Alex", "Morgan");
        System.out.println(result);

    }

    public static <T> T calculator(Operation<T> operation, T value1, T value2) {
        T result = operation.operate(value1, value2);
        System.out.println("result = " + result);
        return result;
    }

    record Person(String firstName, String lastName) {
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }


    }
}
