public class Main {

    public static void main(String[] args) {}

    private static int[] readIntegers(int[] intList) {
        return intList;
    }

    private static int findMin(int... intList) {
        int min = intList[0];

        for (int i : intList) {
            if (min < intList[i]) {
                min = intList[i];
            } else {
                continue;
            }
        }
        return min;
    }
}
