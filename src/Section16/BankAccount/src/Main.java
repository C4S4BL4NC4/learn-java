import dev.lpa.BankAccount.Bank;
import dev.lpa.BankAccount.BankAccount;
import dev.lpa.BankAccount.BankCustomer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");

//        var account = new BankAccount(BankAccount.AccountType.OTHER, 1500);
//        System.out.println("account = " + account);

//        var joe = new BankCustomer("Joe", 1000, 1300);
//        System.out.println(joe);
//        var denis = new BankCustomer("Denis", 3000, 5000);
//        System.out.println(denis);

        var bank = new Bank(1234567);
        bank.addCustomer("Joe", 5000, 1000);

        BankCustomer joe = bank.getCustomer("000000010000000");

        List<BankAccount> accounts = joe.getAccounts();
        System.out.println(joe);

    }
}
