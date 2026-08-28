package dev.lpa;

import external.Child;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");

//        var parent = new Parent();
//        var child = new Child();

        var parent = new Parent("Alex", "01/01/1970");
        var child = new Child("Alice", "01/01/1998");
        var person = new Person("Robert", "01-01-1950");
        var personCopy = new Person(person);
        System.out.println("parent = " + parent);
        System.out.println("child = " + child);
        System.out.println("person = " + person);
        System.out.println("personCopy = " + personCopy);
    }
}
