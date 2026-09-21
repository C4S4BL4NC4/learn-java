package dev.lpa;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        int numberLength = 100_000;
        long[] numbers = new Random().longs(numberLength, 1, numberLength).toArray();
        long sum = Arrays.stream(numbers).sum();

        System.out.println("sum = " + sum);

        ExecutorService executor = Executors.newWorkStealingPool(4);
        
    }
}
