public class Main {

    static void main(String[] args) {
        System.out.println("Latitude Longitude Challenge:");
        var usNationalParks = new Park[] {
            new Park("Yellowstone", "33.331, 55.5512"),
            new Park("Duhrosie", "324.67, 420.69"),
        };

        Layer<Park> parkLayer = new Layer<>(usNationalParks);
        parkLayer.renderLayer();

        var usMajorRivers = new River[] {
            new River("Mississippi", "47.4, 56.53", "12.40, 10.12", "-95.13, -69.204"),
            new River("Missouri", "44.4, 66.53", "22.40, 17.12", "-9.13, -6.204"),
        };

        Layer<River> riverLayer = new Layer<>(usMajorRivers);
        riverLayer.addElements(
            new River("Delaware", "44.44, 55.55", "22.22, 77.77", "52.52, 76.76")
        );
        riverLayer.renderLayer();
    }
}
