package dev.lpa;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");

        var bingoPool = new ArrayList<String>(75);

        int start = 1;
        for (char c : "BINGO".toCharArray()) {
            for (int i = start; i < (start + 15); i++) {
                bingoPool.add("" + c + i);
//                System.out.println("" + c + i);
            }
            start += 15;
        }
    }
}
