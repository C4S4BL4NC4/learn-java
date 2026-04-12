public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World Again");

        String[] splitStrings = "Hello World Again".split(" ");
        printText(splitStrings);
        printText("ALEXI", "WORLD", "FRANK");
    }

    private static void printText(String... textList) {
        for (String t : textList) {
            System.out.println(t);
        }
    }
}
