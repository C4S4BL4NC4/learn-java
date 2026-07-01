public class Main {
    public static void main(String[] args) {
        System.out.println("Comparing");
        Integer five = 5;
        Integer[] numList = {0, 1, 2, 3, 4, 5, 6};

        for (var num : numList) {
            int val = five.compareTo(num);
            System.out.printf("%d %s %d compareTo= %d%n", five, val == 0 ? "==" : (val < 0) ? "<" : ">", num, val);
        }

        String mysteryFruit = "banana";
        String[] fruits = {"orange", "pear", "cherries", "apples", "banana"};

        for (var fruit : fruits) {
            int val = mysteryFruit.compareTo(fruit);
            System.out.printf("%s %s %s compareTo= %d%n", mysteryFruit, fruit.equals(mysteryFruit) ? "==" : "!=", fruit, val);
        }

    }
}
