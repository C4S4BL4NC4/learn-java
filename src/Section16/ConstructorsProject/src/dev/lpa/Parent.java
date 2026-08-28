package dev.lpa;

public class Parent {

    // Executed in order mainly used to set up environment variables
    static {
        System.out.println("In a static initializer.");
    }

    // Final fields must be initialized
    // non-final fields are initialized as null fields
    private final String name;
    private final String dob;

    // Instance initializer executed before any constructors
    {
//        name = "John Doe";
//        dob = "01/01/1970";
        System.out.println("In instance initializer.");
    }

    public Parent(String name, String dob) {
        this.name = name;
        this.dob = dob;
        System.out.println("In the args constructor block.");
    }

    // No args constructor
//    public Parent() {
//        System.out.println("In the no args constructor block.");
//    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", dob='" + dob + '\'';
    }
}
