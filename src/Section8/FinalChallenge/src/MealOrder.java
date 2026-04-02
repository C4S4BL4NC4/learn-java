public class MealOrder {

    private Item side, drink;
    private Burger burger;

    public MealOrder(Item side, Item drink, Burger burger) {
        this.side = side;
        this.drink = drink;
        this.burger = burger;
    }

    public void addToppings() {}

    public void setDrinkSize() {}

    public void printItemizedList() {}

    public void printTotal() {}
}
