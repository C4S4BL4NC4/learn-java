import java.util.ArrayList;

public class Store extends ProductsForSale {
    private ArrayList<String> itemList = new ArrayList<>();
    private ArrayList<String> orderList = new ArrayList<>();

    public Store(String type, String description, double price) {
        super(type, description, price);
    }

    @Override
    public void showDescription() {
        
    }

    public void placeOrder(String item) {
        orderList.add(item);
    }

    public void printOrder() {
        for (String item : orderList) {
            System.out.println(item);
        }
    }

    static void main(String[] args) {
        System.out.println("Hello World");
    }
}
