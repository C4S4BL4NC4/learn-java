public class Dog extends Animal {

    private String earShape;
    private String tailShape;

    public Dog() {
        super("Generic Dog", "Generic", 0);
    }

    public Dog(String type, double weight) {
        super(type, weight < 15 ? "small" : (weight < 35 ? "medium" : "large"), weight);
        this.type = type;
    }

    public Dog(String type, double weight, String earShape, String tailShape) {
        super(type, weight < 15 ? "small" : (weight < 35 ? "medium" : "large"), weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    // Overriding a superclass method
    public void makeNoise() {
        if (type == "Wolf") {
            System.out.print("Ow wooooooooooo!");
        }

        bark();
        System.out.println();
    }

    @Override
    public void move(String speed) {
        super.move(speed);
        // System.out.println("Dogs walk, run and wag their tail");
        if (speed == "slow") {
            run();
            wag();
        } else {
            run();
            bark();
        }
    }

    private void bark() {
        System.out.print("Woof!");
    }

    private void run() {
        System.out.print("Dog running");
    }

    private void walk() {
        System.out.print("Dog walking");
    }

    private void wag() {
        System.out.print("Dog's wagging their tail");
    }

    @Override
    public String toString() {
        return (
            "Dog{" +
            "earShape='" +
            earShape +
            '\'' +
            ", tailShape='" +
            tailShape +
            '\'' +
            "} " +
            super.toString()
        );
    }

    //    public void bark() {
    //        System.out.println("Woof Woof!");
    //    }

    //         public void run() {
    //             System.out.printf("%s is running.\n", this.type);
    //         }
    //
    //         public void walk() {
    //             System.out.printf("%s is walking.\n", this.type);
    //         }
    //
    //         System.out.printf("%s is wagging its tail.\n", this.type);
}
