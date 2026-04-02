package com.xyz.abc;

public class Item {
    private String item;


    public Item(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item='" + item + '\'' +
                '}';
    }
}
