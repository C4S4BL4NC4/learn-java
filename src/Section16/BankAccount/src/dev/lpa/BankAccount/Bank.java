package dev.lpa.BankAccount;

import java.util.Map;

public class Bank {
    private int routingNumber;
    private long lastTransactionId;
    private Map<String, BankCustomer> customers;

    public BankCustomer getCustomer(String id) {
        return null;
    }

    public void addCustomer(String name, double checkingInitialDeposit, double savingsInitialDeposit) {

    }

    public void doTransaction(String id, BankAccount.AccountType type, double amount) {
        
    }
}