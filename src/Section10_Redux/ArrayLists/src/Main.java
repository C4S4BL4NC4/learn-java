import dev.lpa.GroceryItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        GroceryItem oranges = new GroceryItem("Oranges", "Fruits", 3);
        GroceryItem apple = new GroceryItem("Apple");
        String lemon = "Lemons";

//        Object[] items = new Object[3];
//        items[0] = oranges;
//        items[1] = apple;
//        items[2] = lemon;
//
        GroceryItem[] items = new GroceryItem[3];
        items[0] = oranges;
        items[1] = apple;
//        items[2] = lemon; -- ERROR

        System.out.println(Arrays.toString(items));

        ArrayList objectList = new ArrayList();
        objectList.add(oranges);
        objectList.add(lemon);

        System.out.println(objectList.toString());

        ArrayList<GroceryItem> groceryItems = new ArrayList<>();
        groceryItems.add(oranges);
        groceryItems.add(apple);
//        groceryItems.add(lemon); -- ERROR

        System.out.println(groceryItems.toString());

        String[] list = {"banana", "apple", "cherry"};
        List<String> groceries = List.of(list);

        ArrayList<String> itemz = new ArrayList<>(groceries);
        itemz.add("yogurt");
        System.out.println(itemz);

        ArrayList<String> names = new ArrayList<>(List.of("Olmo", "Rodri", "Yamal"));
        System.out.println(names);

        itemz.addAll(names);
        System.out.println(itemz);

        itemz.sort(Comparator.naturalOrder());
        System.out.println(itemz);

        itemz.sort(Comparator.reverseOrder());
        System.out.println(itemz);
    }
}
