package dev.lpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainMailer {
    public static void main(String[] args) {
        String[] names = {"Alex Robbins", "Alex Robbins Ph.D.", "Bob Jones M.D.", "Carol Jones", "Ed Green M.D.", "Ed Green Ph.D.", "Ed Black"};
        List<StringBuilder> population = getNames(names);
        Map<StringBuilder, Integer> counts = new TreeMap<>();
        population.forEach(s -> {
            counts.merge(s, 1, Integer::sum);
        });
        System.out.println("counts = " + counts);
        var clearNames = standardizeName(population);
        System.out.println("clearNames = " + clearNames);

    }

    public static List<StringBuilder> getNames(String[] names) {
        List<StringBuilder> list = new ArrayList<>();
        int index = 3;

        for (var name : names) {
            for (int i = 0; i < index; i++) {
                list.add(new StringBuilder(name));
            }
            index++;
        }
        return list;
    }

    private static List<StringBuilder> standardizeName(List<StringBuilder> list) {
        var newList = new ArrayList<StringBuilder>();
        for (var name : list) {
            for (String suffix : new String[]{"Ph.D.", "M.D."}) {
                int startIndex = -1;
                if ((startIndex = name.indexOf(suffix)) > -1) {
                    name.replace(startIndex - 1, startIndex + suffix.length(), "");
                }
            }
            newList.add(name);
        }
        return newList;
    }
}
