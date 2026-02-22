public class Car {

    private String make = "Honda";
    private String model = "Civic";
    private String color = "Neon-Green";
    private String doors = "2";
    private boolean convertible = true;

    // Getters
    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getDoors() {
        return doors;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public String getMake() {
        return make;
    }

    // Setters
    public void setMake(String make) {
        if (make == null) make = "Unknown";
        this.make = make;
    }

    public void setModel(String model) {
        if (model == null) model = "Unknown";
        this.model = model;
    }

    public void setColor(String color) {
        if (color == null) color = "Unknown";
        this.color = color;
    }

    public void setDoors(String doors) {
        if (doors == null) doors = "Unknown";
        this.doors = doors;
    }

    public void setConvertible(Boolean convertible) {
        this.convertible = convertible;
    }

    public void describeCar() {
        System.out.println(
            doors +
                "-Door " +
                color +
                " " +
                make +
                " " +
                model +
                " " +
                (convertible ? "Convertible" : "")
        );
    }
}
