import java.util.Scanner;

public class MinMaxChallenge {

    public static void main(String[] args) {
        int min,
            max = 0;
        System.out.println("Enter a value(integer): ");
        Scanner scanner = new Scanner(System.in);

        int current = scanner.nextInt();

        if (current == 0) {
            System.out.println("Program terminated");
            scanner.close();
        } else {
            System.out.println("Continue");
            min = current;
            max = current;
            while (true) {
                System.out.printf("Enter a value: ");
                current = scanner.nextInt();
                if (current >= min && current > max) {
                    max = current;
                    System.out.printf("Min: %d || Max: %d\n", min, max);
                    continue;
                } else if (current <= min && current < min) {
                    min = current;
                    System.out.printf("Min: %d || Max: %d\n", min, max);
                    continue;
                } else if (current == 0) {
                    break;
                }
                System.out.printf("Min: %d || Max: %d\n", min, max);
            }
        }
    }
}
