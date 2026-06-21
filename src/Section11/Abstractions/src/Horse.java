public class Horse extends Mammal {
    public Horse(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + " sheds hair in sprint");
    }

    @Override
    public void makeNoise() {

    }
}
