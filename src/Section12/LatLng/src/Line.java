abstract class Line implements Mappable {

    protected double[][] locations;

    public Line(String... locations) {
        this.locations = new double[locations.length][];
        int i = 0;
        for (var j : locations) {
            this.locations[i++] = Mappable.stringToLatLon(j);
        }
    }

    @Override
    public String render() {}
}
