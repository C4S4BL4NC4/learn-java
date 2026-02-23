public class BankAccount {

    private String number;
    private double balance; // Auto sets to 0.00
    private String name;
    private String email;
    private String phone;

    public void depositFunds(double depositAmount) {
        this.balance += depositAmount;
        System.out.println("Deposit of $" + depositAmount);
    }

    public void withdrawFunds(double withdrawAmount) {
        if (this.balance - withdrawAmount < 0) {
            System.out.println("Insufficient Funds!");
        } else {
            this.balance -= withdrawAmount;
            System.out.println("Withdrawal of $" + withdrawAmount);
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
