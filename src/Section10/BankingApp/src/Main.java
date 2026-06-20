public class Main {
    public static void main(String[] args) {
        Customer alex = new Customer("Alex", 1000);
        System.out.println(alex);

        Bank bank = new Bank("Chase");
        bank.addNewCustomer("Rosa", 1200);
        System.out.println(bank.getCustomer("Rosa"));

        bank.addTransaciton("Rosa", 100);
        bank.addTransaciton("Rosa", 500);
        System.out.println(bank.getCustomer("Rosa"));
    }
}
