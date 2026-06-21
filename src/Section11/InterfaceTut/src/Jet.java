public class Jet implements Trackable, FlightEnabled {

    @Override
    public void tackOff() {
        System.out.println(getClass() + " is taking off.");
    }

    @Override
    public void land() {
        System.out.println(getClass() + " is landing.");
    }

    @Override
    public void fly() {
        System.out.println(getClass() + " is flying.");
    }

    @Override
    public void track() {
        System.out.println(getClass() + "'s being tracked.");
    }
}
