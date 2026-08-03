import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main.main");
        List<String> list = new ArrayList<>(List.of("Ashe", "Zoe", "Mundo"));
        //        list.forEach(e -> System.out.println(e));
        list.forEach(System.out::println);
        calculator(Integer::sum, 4, 6);
        calculator(Double::sum, 5.6, 1.4);
        calculator((a, b) -> a + b, "foo", "bar");
        calculator(String::concat, "foo", "bar");
        calculator(String::concat, "foo", "bar");
        BiFunction<String, String, String> b1 = String::concat;
        BinaryOperator<String> b2 = String::concat;
        UnaryOperator<String> u1 = String::toUpperCase;
        calculator(b2, "hello", "world");
        System.out.println(u1.apply("Hi"));
        System.out.println("Hello World".transform(u1));
    }

    private static <T> void calculator(BinaryOperator<T> function, T v1, T v2) {
        T result = function.apply(v1, v2);
        System.out.println(result);
    }
}
