package dev.lpa;

record Person(String name, String dob) {
    public Person(Person person) {
        this(person.name(), person.dob());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        var joe = new Person("Joe", "01/01/1967");
        var jim = new Person("Jim", "01/01/1964");
        var jack = new Person("Jack", "01/01/1987");
        var julie = new Person("Julie", "01/01/1988");
        var jill = new Person("Jill", "01/01/1998");

        // Shallow copying
        var persons = new Person[]{joe, jim, jack, julie, jill};
        var personsCopy = new Person[persons.length];
//        var personsCopy = Arrays.copyOf(persons, persons.length);     // Shallow Copy

//        var personsCopy = new Person[persons.length];   // Manual Deep Copy
//        for (int i = 0; i <= persons.length - 1; i++) {
//            var current = persons[i];
//            personsCopy[i] = new Person(current.name(), current.dob());
//        }


//        Arrays.setAll(personsCopy, i -> new Person(persons[i]));    // Deep Copy with setAll
        personsCopy = persons.clone(); // Deep copy with clone

        for (int i = 0; i <= persons.length - 1; i++) {
            if (persons[i] == personsCopy[i]) {
                System.out.println("Equal reference: " + persons[i]);
            } else {
                System.out.println("Not Equal reference: " + persons[i]);
            }
        }

    }
}
