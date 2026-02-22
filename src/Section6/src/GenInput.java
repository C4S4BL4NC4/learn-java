import java.util.Scanner;

public class GenInput {

    public static void main(String[] arg) {
        getInputFromConsole();
    }

    // No default parameters in JAVA
    public static String getInputFromConsole() {
        String name = System.console().readLine("Hi, What's your Name? ");
        System.out.println("Hi " + name + ", Thanks for taking the course!");
        return "";
    }

    public static String getInputFromScanner() {
        Scanner scanner = new Scanner(System.in);
        return "";
    }

    //    try {
    //
    //    } catch (Exception e ) {
    //
    //    }
}
