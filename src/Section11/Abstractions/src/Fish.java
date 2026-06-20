public class Fish extends Animal {

    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed == "slow") {
            System.out.println(getExplicitType() + "Swims...");
        } else {
            System.out.println(getExplicitType() + "Darts away...");
        }
    }

    @Override
    public void makeNoise() {
        if (type == "Goldfish") {
            System.out.println(getExplicitType() + "blop...");
        } else {
            System.out.println(getExplicitType() + "splash...");
        }
    }
}
