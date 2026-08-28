package dev.lpa;

public record Person(String name, String dob) {


//    // Canonical Constructor is the implicitly generated constructor for a record
//    public Person(String name, String dob) {
//        this.name = name;
//        this.dob = dob.replace('-', '/');
//    }

    // Compact constructor automatically has access used to do checks without dealing with boilerplate
    public Person {
        if (dob == null) throw new IllegalArgumentException("Bad Data");
        dob = dob.replace('-', '/');
    }

    // Custom Constructor is an overloaded constructor of the canonical constructor
    public Person(Person p) {
        this(p.name(), p.dob());
    }


}
