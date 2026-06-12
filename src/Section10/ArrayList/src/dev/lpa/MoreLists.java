package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreLists {
    public static void main(String[] args) {
        String[] items = {"apples", "bananas", "lemons", "cheese"};

        List<String> list = List.of(items);
        System.out.println(list);

        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("honey");

        System.out.println(groceries);

        ArrayList<String> nextList = new ArrayList<>(
                List.of("pickles", "mustard", "ketchup")
        );

        System.out.println(nextList);
        System.out.println(groceries.get(2));
        System.out.println(groceries.contains("lemons"));
        System.out.println(groceries.indexOf("lemons"));
        //.remove()
        //.removeAll()
        //.isEmpty()
        //.clear()
        //.addAll()
        System.out.println(groceries);
        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);
        //.reverseOrder()
        var groceryArray = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceryArray));
    }
}
