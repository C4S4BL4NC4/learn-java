public class Animal {

    protected String type; // protected: subclasses can access it.
    private String size;
    private double weight;

    public Animal() {}

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return (
            "Animal{" +
            "type='" +
            type +
            '\'' +
            ", size='" +
            size +
            '\'' +
            ", weight=" +
            weight +
            '}'
        );
    }

    public void move(String speed) {
        System.out.printf("%s moves at speed of %s.\n", this.type, speed);
    }

    public void makeNoise() {
        System.out.printf("%s makes some noise.\n", this.type);
    }
}
