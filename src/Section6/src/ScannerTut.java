import java.util.Scanner;

public class ScannerTut {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        String name = scan.next();
        System.out.println("Hello, " + name);
        System.out.println("What's your age: ");
        int age = scan.nextInt();
    }
}
