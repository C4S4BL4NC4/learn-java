public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;
        FlightEnabled jet = new Jet();

        bird.move();
        animal.move();
//        flier.move();
//        tracked.move();
        inFlight(flier);
        inFlight(jet);
        Truck truck = new Truck();
        truck.track();
    }

    public static void inFlight(FlightEnabled flier) {
        flier.tackOff();
        flier.fly();
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }
}
