public class Solution {

    // ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6 digits.
    static void main(String[] args) {
        System.out.println(validatePin("1234"));
        System.out.println(validatePin("a234"));
        System.out.println(validatePin("1234567"));
        System.out.println(validatePin("-1234"));
        System.out.println(validatePin("1.456"));
        System.out.println(validatePin("aaaaaa"));
        System.out.println(validatePin("123"));
    }

    public static boolean validatePin(String pin) {
        // Your code here...
        return pin.matches("^\\d{4}(\\d{2})?$");
    }
}
