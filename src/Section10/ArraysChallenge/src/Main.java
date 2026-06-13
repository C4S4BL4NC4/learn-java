import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> items = new ArrayList<>();

        while (true) {
            System.out.println("items -> " + items.toString());
            System.out.println(
                "0 Shutdown" + "\n1 add items" + "\n2 remove items" + "\nEnter a number of action: "
            );
            int option = scanner.nextInt();
            if (option > 2 || option < 0) {
                System.out.println("Invalid option. Try again");
                continue;
            }
            if (option == 0) {
                System.out.println("Quitting...");
                break;
            }
            if (option == 1) {
                System.out.println("Enter a new Item: ");
                String newItem = scanner.nextLine();
                items.add(newItem);
            }
            if (option == 2) {
                if (items.isEmpty()) {
                    System.out.println("Items array is empty");
                }
                System.out.println("Enter item name to remove: ");
                String removableItem = scanner.nextLine();
                items.remove(items.indexOf(removableItem));
                continue;
            }
        }
    }
}
