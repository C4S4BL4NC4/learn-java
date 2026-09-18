package dev.lpa;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");

        BankAccount alice = new BankAccount("Alice", 10000);

        Thread t1 = new Thread(() -> alice.withdraw(2500));
        Thread t2 = new Thread(() -> alice.deposit(5000));
        Thread t3 = new Thread(() -> alice.setName("Elise"));
        Thread t4 = new Thread(() -> alice.withdraw(5000));

        t1.start();
        t2.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Alice balance: %s%n", alice.getBalance());
    }
}
