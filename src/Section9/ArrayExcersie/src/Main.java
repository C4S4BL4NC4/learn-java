import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("ARRAY METHODS MINIMUM CHALLENGE");
        int[] returnedArray = readIntegers();
        System.out.println(Arrays.toString(returnedArray));

        int returnedMin = findMin(returnedArray);
        System.out.println("Min = " + returnedMin);

        int[] reversedArr = reversedArray(returnedArray);
        System.out.println("Reversed Array = " + Arrays.toString(reversedArr));
    }

    private static int[] readIntegers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of integers, seperated by commas: ");
        String input = scanner.nextLine();
        String[] splits = input.split(",");
        int[] vals = new int[splits.length];

        for (int i = 0; i < splits.length; i++) {
            vals[i] = Integer.parseInt(splits[i].trim());
        }
        return vals;
    }

    private static int findMin(int... intList) {
        int min = intList[0];

        for (int i : intList) {
            if (min > i) {
                min = i;
            } else {
                continue;
            }
        }
        return min;
    }

    private static int[] reversedArray(int[] intArray) {
        int i = intArray.length - 1;
        int k = 0;
        int[] reversedArray = new int[intArray.length];

        while (i >= 0) {
            reversedArray[k] = intArray[i];
            k++;
            i--;
        }

        return reversedArray;
    }
}
