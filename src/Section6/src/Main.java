public class Main {
    public static void main(String[] args) {
        int num = 5;

        // Can't use bool, float, and double.
        switch(num) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3: case 4: case 5:
                System.out.println("3, 4, 5");
                break;
            default:
                System.out.println("Another Values");
        }
        System.out.println(getQuarter("OLG"));

    }
    public static String getQuarter(String month) {
//        switch(month) {
//            case "JANUARY":
//            case "FEBRUARY":
//            case "MARCH":
//                return "1st";
//            case "APRIL":
//            case "MAY":
//            case "JUNE":
//                return "2st";
//            case "JULY":
//            case "AUGUST":
//            case "SEPTEMBER":
//                return "3st";
//            case "OCTOBER":
//            case "NOVEMBER":
//            case "DECEMBER":
//                return "4st";
//        }
//        return "BAD";
//        return switch (month) {
//            case "JAN","FEB","MAR" -> "1ST";
//            case "APR","MAY","JUN" -> "2ND";
//            case "JUL","AUG","SEP" -> "3RD";
//            case "OCT","NOV","DEC" -> "4TH";
//            default -> "bad";
//        };
        return switch (month) {
            case "JAN","FEB","MAR" -> "1ST";
            case "APR","MAY","JUN" -> "2ND";
            case "JUL","AUG","SEP" -> "3RD";
            case "OCT","NOV","DEC" -> "4TH";
            default -> {
                String badRes = month + " is bad";
                yield badRes;
            }
        };
    }
}
