public abstract class ProductsForSale {

    protected String type, description;
    protected double price;

    public ProductsForSale(String type, String description, double price) {
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public double getSalesPrice(int quantity) {
        return (double) quantity * this.price;
    }

    public void pricePricedItem(int quantity) {
        System.out.println("123");
    }

    public abstract void showDescription();
}
