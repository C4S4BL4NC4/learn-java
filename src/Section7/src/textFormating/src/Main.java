public class Main {
    public static void main(String[] args) {
        int age = 35;
        System.out.printf("Age: %.2f%n\nBirth Year: %d",(float)age, 2026-age);
        String formatedString = String.format("Your are is %d", age);
        System.out.println(formatedString);
    }
}
