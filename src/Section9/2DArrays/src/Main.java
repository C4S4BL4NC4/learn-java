import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] array = new int[3][3];
        System.out.println(Arrays.toString(array));

        for(int[] outer : array) {
            System.out.println(Arrays.toString(outer));
        }

        System.out.println(Arrays.deepToString(array));

    }
}
