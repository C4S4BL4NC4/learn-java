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
    public List<Object> filterList(List<Object> list) {
        for (Object o : list) {
            System.out.println(o.toString());
            return list.of("123");
        }
    }
}
