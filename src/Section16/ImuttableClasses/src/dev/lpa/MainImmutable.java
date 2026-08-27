package dev.lpa;

public class MainImmutable {
    public static void main(String[] args) {
        System.out.println("MainImmutable.main");
        var jane = new PersonImmutable("Jane", "01/01/1990");
        var jim = new PersonImmutable("Jim", "02/02/1992");
        var joe = new PersonImmutable("Joe", "01/01/1984");

        var johnsKids = new PersonImmutable[]{jane, jim, joe};
        var john = new PersonImmutable("John", "01/01/1960", johnsKids);

        System.out.println(john);

        var johnCopy = new PersonImmutable("John", "01/01/1960");
        System.out.println(johnCopy);

        var kids = johnCopy.getKids();
        kids[0] = jim;
        kids[1] = new PersonImmutable("Ann", "06/07/1998");
        System.out.println(johnCopy);
    }
}
