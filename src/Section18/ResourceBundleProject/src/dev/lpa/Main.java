package dev.lpa;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");

        for (var l : List.of(Locale.US, Locale.CANADA, Locale.CANADA_FRENCH)) {
            ResourceBundle rb = ResourceBundle.getBundle("BasicText", l);
//            System.out.println("rb.getClass().getName() = " + rb.getClass().getName());
//            System.out.println("rb.getBaseBundleName() = " + rb.getBaseBundleName());
//            System.out.println("rb.keySet() = " + rb.keySet());


            System.out.printf("%s %s!%n", rb.getString("hello"), rb.getString("world"));
        }

    }
}
