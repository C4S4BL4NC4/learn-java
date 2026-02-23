public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        car.describeCar();

        BankAccount AlicesAccount = new BankAccount();
//        // Setting values without constructor (Manually)
//        AlicesAccount.setEmail("Alice@wonderland.xyz");
//        AlicesAccount.setName("Alice Wonderland");
//        AlicesAccount.setPhone("0454-453-543");
//
//        AlicesAccount.withdrawFunds(100);
//        AlicesAccount.depositFunds(250);
//        AlicesAccount.withdrawFunds(50);

        System.out.println(AlicesAccount.getName());

        BankAccount BobsAccount = new BankAccount("12234", 1.00, "Bob The Builder", "bob@builder.hom", "9249453594232");
        System.out.println(BobsAccount.getBalance());
        System.out.println(BobsAccount.getEmail());


        BankAccount TimsAccount = new BankAccount("Tim", "Tim@Bulchaka.com", "000000000000");
        System.out.println(TimsAccount.getName());

        ConstructorChallenge Frank = new ConstructorChallenge();
        System.out.printf("%s\n%s\n%s\n",Frank.getName(),Frank.getEmail(), Frank.getPhone());

        ConstructorChallenge Anne = new ConstructorChallenge("Anne", "anne@mail.com");
        System.out.printf("%s\n%s\n%s\n",Anne.getName(),Anne.getEmail(), Anne.getPhone());

        ConstructorChallenge Louis = new ConstructorChallenge("Louis", "louis@mail.com","05000000");
        System.out.printf("%s\n%s\n%s\n",Louis.getName(),Louis.getEmail(), Louis.getPhone());
    }
}
