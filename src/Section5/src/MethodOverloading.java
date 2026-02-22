public class MethodOverloading {

    public static void main(String[] args) {
        System.out.println(doSomething());
        System.out.println(doSomething(1));
        System.out.println(doSomething('x'));
        System.out.println(doSomething(3.14));
        byte b = -128;
        short s = 1500;
        byteMethod(b);
        byteMethod(s);
    }

    public static int doSomething() {
        return 0;
    }

    public static int doSomething(int num) {
        return num;
    }

    public static char doSomething(char c) {
        return c;
    }

    public static double doSomething(double dbl) {
        return dbl;
    }

    public static void byteMethod(byte b) {
        System.out.println("Bytes method used");
    }

    public static void byteMethod(short s) {
        System.out.println("Short method used");
    }
}
