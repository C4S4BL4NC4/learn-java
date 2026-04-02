package dev.lpa;

// Basic Arrays

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        array[6] = 50;

        double[] doubleArray = new double[30];
        doubleArray[2] = 3.55;
        System.out.println(doubleArray[1]);
//        System.out.println(doubleArray[-1]);

        // Array Initializer
        int[] firstTen = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(firstTen.length);

        int[] newArray = new int[] {5,4,3,2,1};
        for (int element : newArray) {
            System.out.print(element + " ");
        }
    }
}
