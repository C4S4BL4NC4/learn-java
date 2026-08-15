import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l", "He", "lo");
        String dText = "He".concat("llo");
        String eText = "hello";

        List<String> hellos = Arrays.asList(aText, bText, cText, dText, eText);

        hellos.forEach(s -> System.out.println(s + ": " + s.hashCode()));
        Set<String> mySet = new HashSet<>(hellos);

        System.out.println("mySet = " + mySet);
        System.out.println("mySet.size() = " + mySet.size());

        Set<String> names = new HashSet<>();
        names.add("Alex");
        names.add("Rosa");
        names.add("Alex");
        System.out.println("names.size()= " + names.size());

        for (String value : mySet) {
            System.out.print(value + ": ");
            for (int i = 0; i < hellos.size(); i++) {
                if (value == hellos.get(i)) {
                    System.out.print(i + ", ");
                }
            }
            System.out.println(" ");
        }
    }
}
