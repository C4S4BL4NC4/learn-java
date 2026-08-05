import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collectionz {

    public static void main(String[] args) {

        System.out.println("Collectionz.main");
        List<String> list = new ArrayList<>();
        String[] array = {"Roger", "Carol", "Benzi", "Alex"};

        list.addAll(Arrays.asList(array));
        System.out.println("list = " + list);
        list.add("Garry");
        System.out.println("The list contains Garry? " + list.contains("Garry"));

        list.removeIf(s -> s.charAt(0) == 'G');
        System.out.println("list = " + list);
        System.out.println("The list contains Garry? " + list.contains("Garry"));

        
    }
}
