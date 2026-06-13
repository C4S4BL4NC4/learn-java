import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner word = new Scanner(System.in);
        ArrayList<String> items = new ArrayList<>();
        boolean flag = true;

        while (flag) {
            System.out.println("items -> " + items.toString());
            System.out.println(
                "0- Shutdown" +
                    "\n1- Add items" +
                    "\n2- Remove items" +
                    "\nEnter a number of action: "
            );
            int option = scanner.nextInt();
            switch (Integer.parseInt(scanner.nextLine())){
                default -> flag = false;
                case 1 -> {
                    System.out.println("Enter Items separated by commas: ");
                    String[] basket = scanner.nextLine().split(",");
                }
                case 2 -> {
                    break;
                }
            }
            items.sort(Comparator.naturalOrder());
            System.out.println(items);
        }
    }
}
