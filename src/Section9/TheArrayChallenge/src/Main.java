import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        int[] mArray = Arrays.copyOf(firstArray, 10);
        System.out.println(Arrays.toString(mArray));
    }

    private static int[] getRandomArray(int len) {
        Random random = new Random();
        int[] intArray = new int[len];

        for (int i = 0; i < len; i++) {
            intArray[i] = random.nextInt(100);
        }
        return intArray;
    }
}
