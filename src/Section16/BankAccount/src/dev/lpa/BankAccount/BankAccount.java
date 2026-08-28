package dev.lpa.BankAccount;


import dev.lpa.dto.Transaction;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {

    private final AccountType accountType;
    private double balance;
    private Map<Long, Transaction> transactions = new LinkedHashMap<>();

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
        return Map.copyOf(transactions);
    }

    void commitTransaction(int routingNumber, long transactionId, String customerId, double amount) {
        balance += amount;
        transactions.put(transactionId, new Transaction(routingNumber, (int) transactionId, Integer.parseInt(customerId), amount));
    }

    public enum AccountType {CHECKING, SAVING, OTHER}


}
