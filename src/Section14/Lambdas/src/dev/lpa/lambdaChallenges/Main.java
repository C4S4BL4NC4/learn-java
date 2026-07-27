package dev.lpa.lambdaChallenges;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    //    public static void main(String[] args) {
    //        Consumer<String> printThePartsLambda = (sentence) -> {
    //            Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
    //        };
    //
    //        printThePartsLambda.accept("Oy mi amor mi amor");
    //        System.out.println(everySecondChar("HAHAHA LMAO DAWG"));
    //        Function<String, String> everySecondCharLambda = source -> Arrays.asList(source.split("")).forEach(s -> );
    //        System.out.println();
    //    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }
}
