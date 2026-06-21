import java.util.ArrayList;
import java.util.List;

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

        ArrayList<FlightEnabled> fliers = new ArrayList<>();
        fliers.add(bird);
        List<FlightEnabled> betterFliers = new ArrayList<>();
        betterFliers.add(bird);

        System.out.println("\nReference types: ");
        triggerFliers(fliers);
        flyFliers(fliers);
        landFliers(fliers);

//        triggerFliers(betterFliers);
//        flyFliers(betterFliers);
//        landFliers(betterFliers);
    }

    public static void inFlight(FlightEnabled flier) {
        flier.tackOff();
        flier.fly();
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }

    public static void triggerFliers(ArrayList<FlightEnabled> fliers) {
        for (var flier : fliers) {
            flier.tackOff();
        }
    }

    public static void flyFliers(ArrayList<FlightEnabled> fliers) {
        for (var flier : fliers) {
            flier.fly();
        }
    }

    public static void landFliers(ArrayList<FlightEnabled> fliers) {
        for (var flier : fliers) {
            flier.land();
        }
    }
}
