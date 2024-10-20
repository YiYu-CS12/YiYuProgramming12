public abstract class TwoDShape {
    private double width;
    private double height;

    // Constructor
    public TwoDShape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Getters and setters
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Abstract method for area
    public abstract double getArea();

    // toString method
    @Override
    public String toString() {
        return "Shape with width: " + width + ", height: " + height + ", with Area: "+ getArea();
    }
}
