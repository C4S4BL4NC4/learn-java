import java.util.Arrays;

abstract class Point implements Mappable {

    protected double[] location = new double[2];

    public Point(String location) {
        this.location = Mappable.stringToLatLon(location);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as point (" + location() + ")");
    }

    private String location() {
        return Arrays.toString(location);
    }
}
