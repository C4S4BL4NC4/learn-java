import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        int[] intArray = new int[5];
        int[] newArray = intArray;

        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(newArray));

        Arrays.fill(intArray, 1);
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(newArray));
    }
}
