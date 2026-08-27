import dev.lpa.BankAccount.BankCustomer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");

//        var account = new BankAccount(BankAccount.AccountType.OTHER, 1500);
//        System.out.println("account = " + account);

        var joe = new BankCustomer("Joe", 1000, 1300);
        System.out.println(joe);
        var denis = new BankCustomer("Denis", 3000, 5000);
        System.out.println(denis);

    }
}
