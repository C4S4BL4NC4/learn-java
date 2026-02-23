//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            LPAStudent s = new LPAStudent(
                "S93200" + i,
                switch (i) {
                    case 1 -> "Leon";
                    case 2 -> "Rick";
                    case 3 -> "Linda";
                    case 4 -> "Susan";
                    case 5 -> "Mary";
                    default -> "Anonymous";
                },
                "05-11-1995",
                "Java Masterclass"
            );
            System.out.println(s);
        }
    }
}
