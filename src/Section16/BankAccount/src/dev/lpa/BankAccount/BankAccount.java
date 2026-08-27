package dev.lpa.BankAccount;


import dev.lpa.dto.Transaction;

import java.util.Map;

public class BankAccount {

    private final AccountType accountType;
    private double balance;
    private Map<Long, Transaction> transactions;

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

    public Map<Long, Transaction> getTransactions() {
        return transactions;
    }

    public boolean commitTransaction(int routingNumber, long transactionId, String customerId, double amount) {
        return false;
    }

    public enum AccountType {CHECKING, SAVING, OTHER}


}
