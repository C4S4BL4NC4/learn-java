import java.util.ArrayList;

public class Bank {

    // Bank
    //-  It has two fields, A String called name and an ArrayList that holds objects of type Branch called branches.
    private String name;
    private ArrayList<Branch> branches = new ArrayList<>(5000);

    //-  A constructor that takes a String (name of the bank). It initializes name and instantiates branches.
    public Bank(String name) {
        this.name = name.toUpperCase();
    }

    //-  And five methods, they are (their functions are in their names):
    //-  addBranch(), has one parameter of type String (name of the branch) and returns a boolean. It returns true if the branch was added successfully or false otherwise.
    public boolean addBranch(String name) {
        String branchName = name.toUpperCase();
        Branch branch = findBranch(branchName);
        if (branch == null) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    //-  addCustomer(), has three parameters of type String (name of the branch), String (name of the customer), double (initial transaction) and returns a boolean. It returns true if the customer was added successfully or false otherwise.
    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName.toUpperCase());
        if (branch != null) {
            return branch.newCustomer(customerName, initialTransaction);
        }
        return false;
    }

    //-  addCustomerTransaction(), has three parameters of type String (name of the branch), String (name of the customer), double (transaction) and returns a boolean. It returns true if the customers transaction was added successfully or false otherwise.
    public boolean addCustomerTransaction(
        String branchName,
        String customerName,
        double transaction
    ) {
        Branch branch = findBranch(branchName.toUpperCase());
        if (branch != null) {
            for (Customer customer : branch.getCustomers()) {
                if (customer.getName().equals(customerName.toUpperCase())) {
                    customer.addTransaction(transaction);
                    return true;
                }
            }
        }
        return false;
    }

    //-  findBranch(), has one parameter of type String (name of the Branch) and returns a Branch. Return the Branch if it exists or null otherwise.
    private Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equalsIgnoreCase(branchName)) {
                return branch;
            }
        }
        return null;
    }

    //-  listCustomers(), has two parameters of type String (name of the Branch), boolean (print transactions) and returns a boolean. Return true if the branch exists or false otherwise. This method prints out a list of customers.
    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName.toUpperCase());
        if (branch != null) {
            System.out.println("Customers in branch " + branch.getName() + ":");
            for (Customer customer : branch.getCustomers()) {
                System.out.println("  - " + customer.getName());
                if (printTransactions) {
                    for (Double transaction : customer.getTransactions()) {
                        System.out.println("      Transaction: $" + transaction);
                    }
                }
            }
            return true;
        }
        return false;
    }
}
