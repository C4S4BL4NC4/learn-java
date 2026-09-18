package dev.lpa;

public class BankAccount {

    private final Object lockName = new Object();
    private final Object lockBalance = new Object();
    private double balance;
    private String name;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        synchronized (lockName) {
            System.out.printf("Setting name: %s\n", name);
            this.name = name;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double balance) {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double originalBalance = this.balance;
        synchronized (lockBalance) {
            this.balance += balance;
        }
        System.out.printf("Deposit: %.2f -> %.2f%n", originalBalance, this.balance);
    }

    public void withdraw(double balance) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (this) {
            double originalBalance = this.balance;
            if (balance < this.balance) {
                this.balance -= balance;
                System.out.printf("Withdraw: %.2f -> .%2f%n", originalBalance, this.balance);
            } else {
                System.out.println("W: Insufficient funds!");
            }
        }
    }
}
