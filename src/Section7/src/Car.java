public class Car {

    private String make = "Honda";
    private String model = "Civic";
    private String color = "Neon-Green";
    private String doors = "2";
    private boolean convertible = true;

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
