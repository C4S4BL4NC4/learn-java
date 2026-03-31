public class IOT {

    public static void main(String[] args) {}
}

class Device {

    private boolean hasWorkToDo;

    public Device(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public boolean isHasWorkToDo() {
        return hasWorkToDo;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
}

class Refrigerator extends Device {

    public Refrigerator(boolean hasWorkToDo) {
        super(hasWorkToDo);
    }

    public void orderFood() {
        System.out.println("Ordering food");
    }
}

class DishWasher extends Device {

    public DishWasher(boolean hasWorkToDo) {
        super(hasWorkToDo);
    }

    public void doDishes() {
        System.out.println("Doing dishes");
    }
}

class CoffeeMaker extends Device {

    public CoffeeMaker(boolean hasWorkToDo) {
        super(hasWorkToDo);
    }

    public void brewCoffee() {
        System.out.println("Brewing coffee");
    }
}

class SmartKitchen extends Device {

    private CoffeeMaker brewMaster;
    private DishWasher dishWasher;
    private Refrigerator iceBox;

    public SmartKitchen(
        boolean hasWorkToDo,
        CoffeeMaker brewMaster,
        DishWasher dishWasher,
        Refrigerator iceBox
    ) {
        super(hasWorkToDo);
        this.brewMaster = brewMaster;
        this.dishWasher = dishWasher;
        this.iceBox = iceBox;
    }

    public void addWater() {
        this.iceBox.setHasWorkToDo(true);
    }

    public void pourMilk() {
        this.brewMaster.setHasWorkToDo(true);
    }

    public void loadDishwasher() {
        this.dishWasher.setHasWorkToDo(true);
    }

    public void setKitchenState(boolean refState, boolean dishwState, boolean cfeeState) {
        this.iceBox.setHasWorkToDo(refState);
        this.dishWasher.setHasWorkToDo(dishwState);
        this.brewMaster.setHasWorkToDo(cfeeState);
    }

    public void doKitchenWork() {}
}
