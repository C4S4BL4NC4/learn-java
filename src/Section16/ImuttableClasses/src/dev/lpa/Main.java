package dev.lpa;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");

//        var jane = new Person();
//        jane.setName("Jane");
//        var jim = new Person();
//        jim.setName("Jim");
//        var joe = new Person();
//        joe.setName("Joe");
//
//        var john = new Person();
//        john.setName("John");
//        john.setDob("01/01/1970");
//        john.setKids(new Person[]{jane, jim, joe});
//        System.out.println(john);

        var jane = new Person("Jane", "01/01/1990");
        var jim = new Person("Jim", "02/02/1992");
        var joe = new Person("Joe", "01/01/1984");

        var johnsKids = new Person[]{jane, jim, joe};
        var john = new Person("John", "01/01/1960", johnsKids);

        System.out.println(john);
        john.setKids(new Person[]{new Person("Ann", "01/01/1995")});
        System.out.println(john);

        var kids = john.getKids();
        kids[0] = jim;     // WHY?
        System.out.println(john);

        kids = null;
        System.out.println(john);
    }
}
