import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main.main");
        ArrayList<String> myArray = new ArrayList<>(List.of("Annie", "Corki", "Teemo"));
        myArray.forEach(c -> System.out.println(c));
        System.out.println(upperCaseIt(myArray));
        System.out.println(getRandomMid(myArray));
        System.out.println(getLastName(myArray));
    }

    public static ArrayList<String> upperCaseIt(ArrayList<String> myArr) {
        ArrayList<String> returnable = new ArrayList<>();
        myArr.forEach(e -> returnable.add(e.toUpperCase()));
        return returnable;
    }

    public static ArrayList<String> getRandomMid(ArrayList<String> arr) {
        Random random = new Random();
        ArrayList<String> result = new ArrayList<>();
        arr.forEach(e -> {
            char letter = (char) (random.nextInt(26) + 65);
            String s = e + " " + letter + ".";
            result.add(s);
        });
        return result;
    }

    public static ArrayList<String> getLastName(ArrayList<String> arr) {
        ArrayList<String> result = new ArrayList<>();
        arr.forEach(e -> {
            String reversed = new StringBuilder(e.toUpperCase()).reverse().toString();
            result.add(reversed);
        });
        return result;
    }
}
