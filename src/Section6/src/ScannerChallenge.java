import java.util.Scanner;

public class ScannerChallenge {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username: ");

        String userName = myObj.nextLine();
        System.out.println("Username is: " + userName);
        for (int i = 0; i < 5; i++) {
            System.out.printf("Enter number #%d: ", i);
            Scanner myNum = new Scanner(System.in);
            if (!myNum.hasNextInt()) {
                System.out.println("Not an integer!");
                break;
            }
            int num = myNum.nextInt();
            System.out.println(i + "::" + num);
        }
    }
}
