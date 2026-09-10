import java.util.*;

record Contact(String name) {

}

public class TreeSetMain {
    public static void main(String[] args) {
        System.out.println("TreeSetMain.main");

        Set<String> hash = new HashSet<>();
        hash.add("banana");
        hash.add("apple");
        hash.add("cherry");
        System.out.println(hash);   // unpredictable order, e.g. [banana, cherry, apple]

        Set<String> linked = new LinkedHashSet<>();
        linked.add("banana");
        linked.add("apple");
        linked.add("cherry");
        System.out.println(linked); // [banana, apple, cherry] — always insertion order

        Set<Integer> tree = new TreeSet<>();
        tree.add(5);
        tree.add(1);
        tree.add(3);
        System.out.println(tree);   // [1, 3, 5] — always sorted, automatically

        System.out.println("------------------");

        Contact daffy = new Contact("Daffy");
        Contact daisy = new Contact("Daisy");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");

        for (var c : List.of(daffy, daisy, snoopy, archie)) {
            System.out.println(c);
        }

    }
}
