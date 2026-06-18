import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public boolean addCustomer(String name) {
        if (name != null && customers.) {
            customers.add(new Customer(name));
            return true;
        }
        return false;
    }
}
