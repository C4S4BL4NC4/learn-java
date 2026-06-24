public class Isograms {

    static void main(String[] args) {
        System.out.println(isIsogram("Dermatoglyphics"));
        System.out.println(isIsogram("aba"));
        System.out.println(isIsogram("moOse"));
    }

    //SOLVED: Time: 2276ms Passed: 2 Failed: 0
    public static boolean isIsogram(String str) {
        return !str.toUpperCase().matches("(?i).*([a-z]).*\\1.*");
    }
}
