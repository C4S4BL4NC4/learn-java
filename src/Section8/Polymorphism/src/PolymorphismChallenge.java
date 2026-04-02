public class PolymorphismChallenge {
    public static void main(String[] args) {
        Car skoda = new Car("Skoda");
        runRace(skoda);
    }

    public static void runRace(Car car) {
        car.startEngine();
        car.drive();
    }
}
