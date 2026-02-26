public class Dog extends Animal {

    private String earShape;
    private String tailShape;

    public Dog() {
        super("Generic Dog", "Generic", 0);
    }

    public Dog(String type, double weight, String earShape, String tailShape) {
        super(type, weight < 15 ? "small" : (weight < 35 ? "medium" : "large"), weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
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

    public void bark() {
        System.out.println("Woof Woof!");
    }

    //     public void run() {
    //         System.out.printf("%s is running.\n", this.type);
    //     }

    //     public void walk() {
    //         System.out.printf("%s is walking.\n", this.type);
    //     }

    //     System.out.printf("%s is wagging its tail.\n", this.type);
}
