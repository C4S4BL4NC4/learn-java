public class Floor {

    private double width, length;

    public Floor(double width, double length) {
        if (length < 0 || width < 0) {
            if (length < 0 && width >= 0) {
                this.length = 0;
                this.width = width;
            } else if (width < 0 && length >= 0) {
                this.width = 0;
                this.length = length;
            } else {
                this.length = 0;
                this.width = 0;
            }
        } else {
            this.length = length;
            this.width = width;
        }
    }

    public double getArea() {
        return this.width * this.length;
    }
}
