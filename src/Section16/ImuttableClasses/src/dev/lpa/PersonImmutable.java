package dev.lpa;

import java.util.Arrays;

public class PersonImmutable {

    // private and final fields.
    // don't define setters.
    // create defensive copies in all getters.
    // use constructors or factory methods to set data, making copies mutable reference data.
    // mark the class final or make all constructors private.

    private final String name;
    private final String dob;
    private final PersonImmutable[] kids;

    public PersonImmutable(String name, String dob, PersonImmutable[] kids) {
        this.name = name;
        this.dob = dob;
        this.kids = kids == null ? null : Arrays.copyOf(kids, kids.length);
    }

    public PersonImmutable(String name, String dob) {
        this(name, dob, null);
    }

    protected PersonImmutable(PersonImmutable person) {
        this(person.getName(), person.getDob(), person.getKids());
    }

    @Override
    public String toString() {
        String kidsString = "N/A";
        if (kids != null) {
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].name);
            kidsString = String.join(", ", names);
        }
        return "name=" + name +
                ", dob=" + dob +
                ", kid=" + kidsString;
    }

    public String getName() {
        return name;
    }


    public String getDob() {
        return dob;
    }


    public final PersonImmutable[] getKids() {
        return kids == null ? null : Arrays.copyOf(kids, kids.length);
    }

}
