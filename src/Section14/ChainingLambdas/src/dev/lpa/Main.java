package dev.lpa;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        String name = "Tim";
        Function<String, String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));

        Function<String, String> lastName = s -> s.concat(" Buchalka");
        Function<String, String> uCaseLastName = uCase.andThen(lastName);
        System.out.println(uCaseLastName.apply(name));

        Function<String, String> uCaseFull = uCase.compose(lastName);
        System.out.println(uCaseFull.apply(name));

    }
}
