public class Item {

    private String name, type, size;
    private double price;

    public Item(String name, String type, String size, double price) {
        this.name = name.toUpperCase();
        this.type = type.toUpperCase();
        this.size = size.toUpperCase();
        this.price = price;
    }

    public double getBasePrice() {
        return 0;
    }

    public double getAdjustedPrice() {
        return 0;
    }

    public void printItem() {}
}
