import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] sArray = { "Alice", "Mark", "Dominique", "Rosie", "Hannah", "Jake", "Bobby" };
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));

        if (Arrays.binarySearch(sArray, "Ruby") >= 0) {
            System.out.println("Found mark");
        } else {
            System.out.println("Not found!");
        }

        int[] n1 = { 1, 2, 3, 4, 5 };
        int[] n2 = { 1, 2, 3, 4, 5 };

        // Arrays.equal checks for length and positions
        if(Arrays.equals(n1, n2)) {
            System.out.println("Arrays are equal!");
        } else {
            System.out.println("Arrays not equal!");
        }
    }
}
