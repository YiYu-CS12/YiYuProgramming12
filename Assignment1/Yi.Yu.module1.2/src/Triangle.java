public class Triangle extends TwoDShape {
    private double side1;
    private double side2;
    private double side3;

    // Constructors
    // As I'm not able to calculate three sides with the given width and height, I assume the constructor
    // with two parameters construct a right triangle
    public Triangle(double width, double height) {
        super(width, height);
        this.side1 = width;
        this.side2 = height;
        this.side3 = Math.sqrt(width * width + height * height);
    }

    public Triangle(double side1, double side2, double side3) {
        super(side1, 0);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        super.setHeight(heronsHeight());
    }

    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    private double heronsHeight() {
        double area = getArea();
        return (2 * area) / getWidth();
    }

    @Override
    public String toString() {
        return "Triangle with sides: " + side1 + ", " + side2 + ", " + side3 + ", with Area: "+ getArea();
    }
}
