public class Triangle extends TwoDShape implements Rotate {
    private double side1;
    private double side2;
    private double side3;
    private double currentRotation;

    // Constructors
    // As I'm not able to calculate three sides with the given width and height, I assume the constructor
    // with two parameters construct a right triangle
    public Triangle(double width, double height) {
        super(width, height);
        this.side1 = width;
        this.side2 = height;
        this.side3 = Math.sqrt(width * width + height * height);
        this.currentRotation = 0;
    }

    public Triangle(double side1, double side2, double side3) {
        super(side1, 0);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.currentRotation = 0;
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

    // Getters and setters for sides
    public double getSide1() {
        return side1;
    }
    public void setSide1(double side1) {
        this.side1 = side1;
    }
    public double getSide2() {
        return side2;
    }
    public void setSide2(double side2) {
        this.side2 = side2;
    }
    public double getSide3() {
        return side3;
    }
    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public String toString() {
        return "Triangle [sides: " + side1 + ", " + side2 + ", " + side3 + ", rotation: " + currentRotation + " degrees]";
    }

    // Rotate implementations
    // Rotate implementations
    @Override
    public void rotate90() {
        currentRotation = (currentRotation + 90) % 360;
        System.out.println("Triangle rotated 90 degrees.");
    }

    @Override
    public void rotate180() {
        currentRotation = (currentRotation + 180) % 360;
        System.out.println("Triangle rotated 180 degrees.");
    }

    @Override
    public void rotate(double degree) {
        currentRotation = (currentRotation + degree) % 360;
        System.out.println("Triangle rotated " + degree + " degrees.");
    }

}
