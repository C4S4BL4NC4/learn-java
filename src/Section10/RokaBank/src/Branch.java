import java.util.ArrayList;
import java.util.Locale;

public class Branch {

    //  -  It has two fields, A String called name and an ArrayList that holds objects of type Customer called customers.
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>(5000);

    //-  A constructor that takes a String (name of the branch). It initializes name and instantiates customers.
    public Branch(String name) {
        this.name = name.toUpperCase();
    }

    //-  And five methods, they are (their functions are in their names):
    //-  getName(), getter for name.
    public String getName() {
        return name;
    }

    //-  getCustomers(), getter for customers.
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    //-  newCustomer(), has two parameters of type String (name of customer), double (initial transaction) and returns a boolean. Returns true if the customer was added successfully or false otherwise.
    public boolean newCustomer(String customerName, double initialDeposit) {
        String name = customerName.toUpperCase();
        if (findCustomer(name) == null) {
            Customer customer = new Customer(name);
            customer.addTransaction(initialDeposit);
            customers.add(customer);
            return true;
        }
        return false;
    }

    //-  addCustomerTransaction(), has two parameters of type String (name of customer), double (transaction) and returns a boolean. Returns true if the customers transaction was added successfully or false otherwise.
    public boolean addCustomerTransaction(String customerName, double transaction) {
        String name = customerName.toUpperCase();
        Customer customer = findCustomer(name);
        if (customer == null) return false;
        customer.addTransaction(transaction);
        return true;
    }

    //-  findCustomer(), has one parameter of type String (name of customer) and returns a Customer. Return the Customer if they exist, null otherwise.
    private Customer findCustomer(String customerName) {
        String name = customerName.toUpperCase();
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
}
