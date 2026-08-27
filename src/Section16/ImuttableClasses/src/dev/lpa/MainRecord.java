package dev.lpa;

public class MainRecord {
    public static void main(String[] args) {
        var jane = new PersonRecord("Jane", "01/01/1990");
        var jim = new PersonRecord("Jim", "02/02/1992");
        var joe = new PersonRecord("Joe", "01/01/1984");

        var johnsKids = new PersonRecord[]{jane, jim, joe};
        var john = new PersonRecord("John", "01/01/1960", johnsKids);

        System.out.println(john);

        var johnCopy = new PersonRecord("John", "01/01/1960");
        System.out.println(johnCopy);

        var kids = johnCopy.kids();
        kids[0] = jim;
        kids[1] = new PersonRecord("Ann", "06/07/1998");
        System.out.println(johnCopy);


    }
}
