public abstract class Animal {

    protected String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    // Abstract: can't be private or have body
    public abstract void move(String speed);

    public abstract void makeNoise();

    public final String getExplicitType() {
        return getClass().getSimpleName() + "( " + type + " )";
    }
}
