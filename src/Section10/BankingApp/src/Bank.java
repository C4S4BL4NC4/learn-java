import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Customer> customers = new ArrayList<>(5000);

    public Bank(String name) {
        this.name = name;
    }

    public Customer getCustomer(String name) {
        for (var customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        System.out.println("Customer not found");
        return null;
    }

    public void addTransaciton(String name, double amount) {
        Customer customer = getCustomer(name);

        if (customer != null) {
            customer.getTransactions().add(amount);
        }
    }

    public void printStatement(String name) {
        Customer customer = getCustomer(name);
        if (customer != null) {
            System.out.println("-".repeat(30));
            System.out.println("Customer name: " + customer.getName());
            System.out.println("Transactions: ");
            for (double d : customer.getTransactions()) {
                System.out.printf("$%10.2f (%s)%n", d, d < 0 ? "debit" : "credit");
            }
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }

    public void addNewCustomer(String customerName, double initialDeposit) {
        if (getCustomer(customerName) == null) {
            Customer customer = new Customer(customerName, initialDeposit);
            customers.add(customer);
            System.out.println("Customer " + customer.getName() + " was added successfully");
        }
    }
}
