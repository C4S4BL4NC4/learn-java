public class Line implements Mappable {

    protected String name;
    protected double lat, lng;

    public Line(String name, double lat, double lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public void render() {}
}
