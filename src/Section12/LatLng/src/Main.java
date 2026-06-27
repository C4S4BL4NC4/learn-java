public class Main {

    static void main(String[] args) {
        System.out.println("Latitude Longitude Challenge:");
        var usNationalParks = new Park[] {
            new Park("Yellowstone", "33.331, 55.5512"),
            new Park("Duhrosie", "324.67, 420.69"),
        };
        for (var i : usNationalParks) {
            System.out.println(i.toString());
        }
    }
}
