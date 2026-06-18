public class Main {
    static void main(String[] args) {

        // Manual boxing
        Integer boxed = Integer.valueOf(23);
        Integer depBox = new Integer(3);

        // Unboxing
        int unbox = boxed.intValue();

        // Autoboxing
        Integer auto = 6;
        int autounbox = auto;
    }
}
