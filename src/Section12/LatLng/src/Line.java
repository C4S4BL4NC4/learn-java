abstract class Line implements Mappable {

    protected String name;
    protected double[][] locations;

    public Line(String name, double[][] locations) {
        this.name = name;
        this.locations = locations;
    }

    @Override
    public String render() {}
}
