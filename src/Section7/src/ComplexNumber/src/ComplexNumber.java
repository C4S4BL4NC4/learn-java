public class ComplexNumber {

    // write code here
    private double real, imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public double getReal() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public void add(double real, double imaginary) {
        this.setReal(real + this.real);
        this.setImaginary(imaginary + this.imaginary);
    }

    public void add(ComplexNumber ComplexNumber) {
        this.setReal(this.real + ComplexNumber.getReal());
        this.setImaginary(this.imaginary + ComplexNumber.getImaginary());
    }

    public void subtract(ComplexNumber ComplexNumber) {
        this.setReal(this.real - ComplexNumber.getReal());
        this.setImaginary(this.imaginary - ComplexNumber.getImaginary());
    }

    public void subtract(double real, double imaginary) {
        this.setReal(this.real - real);
        this.setImaginary(this.imaginary - imaginary);
    }
}
