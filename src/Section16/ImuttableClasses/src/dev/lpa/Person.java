package dev.lpa;

import java.util.Arrays;

public class Person {
    String name;
    String dob;
    Person[] kids;

    public Person(String name, String dob, Person[] kids) {
        this.name = name;
        this.dob = dob;
        this.kids = kids;
    }

    public Person(String name, String dob) {
        this(name, dob, null);
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


    public Person[] getKids() {
        return kids;
    }

    public void setKids(Person[] kids) {
        this.kids = kids;
    }
}
