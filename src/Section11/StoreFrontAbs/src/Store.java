import java.util.ArrayList;

public record OrderItem {
    public int quantity;
    public ProductsForSale product;

    public OrderItem(int quantity, ProductsForSale product) {
        this.quantity = quantity;
        this.product = product;
    }
}

public class Store {
    static void main(String[] args) {

    }
}
