public class StringMethods {

    public static void main(String[] args) {
        String birthDate = "25/11/1983";
        int startingIndex = birthDate.indexOf("1983");

        System.out.println("Starting Index: " + startingIndex);
        System.out.println("Birth year: " + birthDate.substring(startingIndex));
        System.out.println("Month: " + birthDate.substring(3, 5));

        String newDate = String.join("/", "25", "11", "1992");
        System.out.println("newDate= " + newDate);

        // concat
        // .indent with negatives removes spaces
        String helloWorld = "Hello " + "World";
        helloWorld.concat(" and goodbye!");

        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World");
        helloWorldBuilder.append(" and Goodbye!"); // Floating randomly in memory (unused)

        printInformation(helloWorld);
        printInformation(helloWorldBuilder.toString());
    }

    public static void printInformation(String string) {
        System.out.println("String= " + string);
        System.out.println("Length= " + string.length());
    }
}
