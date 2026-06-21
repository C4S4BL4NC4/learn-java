public class Bird extends Animal implements FlightEnabled, Trackable {

    @Override
    public void move() {
        System.out.println("flap wings");
    }

    @Override
    public void tackOff() {
        System.out.println( getClass() + " is taking off.");
    }

    @Override
    public void land() {
        System.out.println( getClass() + " is landing.");
    }

    @Override
    public void fly() {
        System.out.println( getClass() + " is flying.");
    }

    @Override
    public void track() {
        System.out.println( getClass() + "'s being tracked.");
    }
}
