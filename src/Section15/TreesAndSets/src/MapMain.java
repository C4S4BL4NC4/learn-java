import java.util.HashMap;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {
        System.out.println("MapMain.main");

        Map<String, Integer> words = new HashMap<>();
        words.put("one", 0);
        words.put("one", 1);
        words.put("two", 2);
        words.put("three", 3);
        words.put("four", 4);
        words.put("five", 5);

        System.out.println("words.get(\"one\") = " + words.get("one"));
        System.out.println("words.get(\"seven\") = " + words.get("seven"));
        System.out.println("words.keySet() = " + words.keySet());
        System.out.println("words.values() = " + words.values());
        System.out.println("words.containsKey(\"one\") = " + words.containsKey("one"));
        System.out.println("words.containsValue(1) = " + words.containsValue(1));
        System.out.println("words.entrySet() = " + words.entrySet());
        for (var kv : words.entrySet()) {
            System.out.println(kv.getKey() + " = " + kv.getValue());
        }
    }
}
