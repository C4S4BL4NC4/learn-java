import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Main {

    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Main.main");
        List<String> names = new ArrayList<>(List.of("foRtUNe", "lUCIan", "BlitZCrank"));
        List<String> upped = new ArrayList<>();
        List<String> midInit = new ArrayList<>();
        List<String> lastName = new ArrayList<>();

        UnaryOperator<String> upper = String::toUpperCase;
        names.forEach(e -> upped.add(upper.apply(e)));

        

        System.out.println("upped = " + upped);
        System.out.println("midInit = " + midInit);
        System.out.println("lastName = " + lastName);
    }
}
