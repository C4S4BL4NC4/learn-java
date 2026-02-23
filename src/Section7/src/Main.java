public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        car.describeCar();
        
        BankAccount AlicesAccount = new BankAccount();
        AlicesAccount.withdrawFunds(100);
        AlicesAccount.depositFunds(250);
        AlicesAccount.withdrawFunds(50);
    }
}
