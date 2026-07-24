import dev.bro.Dog;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        Dog dog1 = new Dog();
        Dog scooby = new Dog() {

            @Override
            public void bark() {
                System.out.println("Ruh ruh");
            }
        };

        dog1.bark();
        scooby.bark();
    }

}
