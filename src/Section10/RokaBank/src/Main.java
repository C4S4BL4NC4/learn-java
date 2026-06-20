public class Main {

    static void main(String[] args) {
        Bank bank = new Bank("National Australia Bank");

        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomers("Adelaide", true);

        //In Bank, use the findBranch() method in each of the other four methods to validate a branch. Do the same thing in Branch with findCustomer() - except for the two getters.
        //TIP:  In Customer, think about what else you need to do in the constructor when you instantiate a Customer object.
        //TIP:  Think about what methods you need to call from another class when implementing a method.
        //TIP:  Be extremely careful with the spelling of the names of the fields, constructors and methods.
        //TIP:  Be extremely careful about spaces and spelling in the printed output.
        //NOTE:  All transactions are deposits (no withdraws/balances).
        //NOTE:  All fields are private.
        //NOTE:  All constructors are public.
        //NOTE:  All methods are public (except for findBranch() and findCustomer() which are private).
        //NOTE:  There are no static members.
        //NOTE:  Do not add a main method to the solution code.
        //NOTE: Classes that are not in the java.lang package should be manually imported.
        //NOTE:  If you get an error from the Evaluate class, it's most likely the constructor. Check if you've added a constructor or if the constructor has the right arguments.
    }
}
