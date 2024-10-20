public class TwoDShape {
    private double width;
    private double height;

    // Constructor
    public TwoDShape() {
        this.width = 0;
        this.height = 0;
    }

    public TwoDShape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Get()/Set()
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

    // Get Area
    public double getArea() {
        return width * height;
    }

    // toString
    @Override
    public String toString() {
        return "Width: " + width + ", Height: " + height;
    }
}