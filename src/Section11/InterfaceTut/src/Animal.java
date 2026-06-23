enum FlightStages implements Trackable {
    GROUNDED,
    LAUNCH,
    CRUISE,
    DATA_COLLECTION;

    @Override
    public void track() {
        if (this != GROUNDED) {
            System.out.println("Monitoring " + this);
        }
    }
}

record DragonFly(String name, String type) implements FlightEnabled {
    @Override
    public void tackOff() {}

    @Override
    public void land() {}

    @Override
    public void fly() {}
}

class Satellite implements OrbitEarth {

    @Override
    public void achieveOrbit() {
        System.out.println("Orbit achieved!");
    }

    @Override
    public void tackOff() {}

    @Override
    public void land() {}

    @Override
    public void fly() {}

    static void log(String description) {
        var today = new java.util.Date();
        System.out.println(today + ": " + description);
    }
}

interface OrbitEarth extends FlightEnabled {
    double g = 9.81;
    void achieveOrbit();
}

interface FlightEnabled {
    double KM_TO_MI = 0.621371;
    double MI_TO_KM = 1.60934;
    public abstract void tackOff();
    abstract void land();
    void fly();

    default FlightStages transitions(FlightStages stage) {
        System.out.println("Transitions is not impelmented in " + this.getClass().getName());
        return null;
    };
}

interface Trackable {
    void track();
}

public abstract class Animal {

    public abstract void move();
}
