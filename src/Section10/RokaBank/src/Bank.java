import java.util.ArrayList;

public class Bank {

    // Bank
    //-  It has two fields, A String called name and an ArrayList that holds objects of type Branch called branches.
    private String name;
    private ArrayList<Branch> branches = new ArrayList<>(5000);

    //-  A constructor that takes a String (name of the bank). It initializes name and instantiates branches.
    public Bank(String name) {
        this.name = name;
    }

    //-  And five methods, they are (their functions are in their names):
    //-  addBranch(), has one parameter of type String (name of the branch) and returns a boolean. It returns true if the branch was added successfully or false otherwise.
    public boolean addBranch(String branchName) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    //-  addCustomer(), has three parameters of type String (name of the branch), String (name of the customer), double (initial transaction) and returns a boolean. It returns true if the customer was added successfully or false otherwise.
    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        Customer customer = findCustomer(customerName);
        if (branch == null && customer == null) {
            return true;
        }
        return false;
    }

    //-  addCustomerTransaction(), has three parameters of type String (name of the branch), String (name of the customer), double (transaction) and returns a boolean. It returns true if the customers transaction was added successfully or false otherwise.
    public boolean addCustomerTransaction(
        String branchName,
        String customerName,
        double transaction
    ) {
        return false;
    }

    //-  findBranch(), has one parameter of type String (name of the Branch) and returns a Branch. Return the Branch if it exists or null otherwise.
    public Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().toUpperCase() == branchName.toUpperCase()) {
                return branch;
            }
        }
        return null;
    }

    //-  listCustomers(), has two parameters of type String (name of the Branch), boolean (print transactions) and returns a boolean. Return true if the branch exists or false otherwise. This method prints out a list of customers.
    public boolean listCustomers(String branchName, boolean printTransactions) {
        return true;
        return false;
    }
}
