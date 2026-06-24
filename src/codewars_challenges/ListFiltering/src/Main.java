import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
         *Kata.filterList(List.of(1, 2, "a", "b")) => List.of(1,2)
         *Kata.filterList(List.of(1, "a", "b", 0, 15)) => List.of(1,0,15)
         *Kata.filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 123)) => List.of(1, 2, 123)
         * */
        System.out.println();
        filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 123));
    }

    // SOLVED: Time: 2392ms Passed: 3 Failed: 0
    public static List<Object> filterList(List<Object> list) {
        ArrayList<Object> output = new ArrayList<>();
        for (Object item : list) {
            if (item instanceof Integer) {
                System.out.println(item);
                output.add((int) item);
            }
        }
        return output;
    }
}
