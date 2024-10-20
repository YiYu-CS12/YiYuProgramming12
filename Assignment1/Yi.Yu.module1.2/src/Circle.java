public class Circle extends TwoDShape {
    private static final double PI = 3.14159;
    private double radius;

    public Circle(double radius) {
        super(radius * 2, radius * 2);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        setWidth(radius * 2);
        setHeight(radius * 2);
    }

    @Override
    public String toString() {
        return "Circle with radius: " + radius + ", with Area: "+ getArea();
    }
}
