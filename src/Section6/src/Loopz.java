public class Loopz {

    public static void main(String[] args) {
        for (int x = 0; x < 10; x++) {
            System.out.println(x);
        }

        while (true) {
            System.out.println("While loop");
            break;
        }

        do {
            System.out.println("Do While loop");
            int age = 23;
            String name = "Rocky";
            System.out.printf("Age: %d\nName: %s\n", age, name);
            break;
        } while (true);

        int dateOfBirth = Integer.parseInt("1999");
        String name = "Alice".toUpperCase();
        System.out.println(name);
    }
}
