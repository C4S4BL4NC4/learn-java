package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;

record GroceryItem(String name, String type, int count) {
    public GroceryItem(String name) {
        this(name, "DAIRY", 1);
    }
}

public class Main {

    public static void main(String[] args) {
        //        Object[] groceryList = new Object[3];
        //        groceryList[0] = new GroceryItem("MILK");
        //        groceryList[1] = new GroceryItem("ORANGE", "PRODUCE", 10);
        //        groceryList[2] = "APPLE";

        //        GroceryItem[] groceryList = new GroceryItem[3];
        //        groceryList[0] = new GroceryItem("MILK");
        //        groceryList[1] = new GroceryItem("ORANGE", "PRODUCE", 10);
        //        groceryList[2] = "APPLE";

        GroceryItem[] groceryList = new GroceryItem[3];
        groceryList[0] = new GroceryItem("MILK");
        groceryList[1] = new GroceryItem("ORANGE", "PRODUCE", 10);
        groceryList[2] = new GroceryItem("APPLE", "PRODUCE", 12);
        System.out.println(Arrays.deepToString(groceryList));

        ArrayList<GroceryItem> groceryArray = new ArrayList<>();
        groceryArray.add(new GroceryItem("BUTTER"));
        groceryArray.add(new GroceryItem("CHEESE"));
        groceryArray.add(new GroceryItem("YOGURT"));

        System.out.println(groceryArray);
    }
}
