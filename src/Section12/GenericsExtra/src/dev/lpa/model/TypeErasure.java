package dev.lpa.model;

import java.util.List;
import java.util.Locale;

public class TypeErasure {

//    public static void testList(List<String> list) {
//        for (var element : list) {
//            System.out.println(element.toLowerCase(Locale.ROOT));
//        }
//    }
//
//    public static void testList(List<Integer> list) {
//        for (var element : list) {
//            System.out.println(element.floatValue());
//        }
//    }

    public static void testList(List<?> list) {
        for (var element : list) {
            if (element instanceof Integer i) {
                System.out.println(i.floatValue());
            }
            if (element instanceof String s) {
                System.out.println(s.toUpperCase(Locale.ROOT));
            }
        }
    }
}
