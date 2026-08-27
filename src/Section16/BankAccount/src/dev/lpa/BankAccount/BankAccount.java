package dev.lpa.BankAccount;


public class BankAccount {

    private final AccountType accountType;
    private final double balance;

    public BankAccount(AccountType type, double balance) {
        this.accountType = type;
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public String toString() {
        return "%s $%.2f".formatted(accountType, balance);
    }

    public double getBalance() {
        return balance;
    }

    public enum AccountType {CHECKING, SAVING, OTHER}


}
