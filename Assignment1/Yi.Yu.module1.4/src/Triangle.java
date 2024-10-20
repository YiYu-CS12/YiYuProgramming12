class Triangle extends TwoDShape implements Rotate {
    private double side1;
    private double side2;
    private double side3;
    private double currentRotation;  // Field to track the current rotation angle

    /**
     * Constructs a triangle using width and height.
     *
     * @param width  the width of the triangle
     * @param height the height of the triangle
     * @param colour the colour of the triangle
     */
    public Triangle(double width, double height, Colour colour) {
        super(width, height, colour);
        this.side1 = width;
        this.side2 = height;
        this.side3 = Math.sqrt(width * width + height * height);
        this.currentRotation = 0;  // Initialize rotation status to 0 degrees
    }
    /**
     * Constructs a triangle with three sides.
     *
     * @param side1  the length of the first side
     * @param side2  the length of the second side
     * @param side3  the length of the third side
     * @param colour the colour of the triangle
     */
    public Triangle(double side1, double side2, double side3, Colour colour) {
        super(side1, 0, colour);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.currentRotation = 0;  // Initialize rotation status to 0 degrees
        super.setHeight(heronsHeight());
    }

    /**
     * Calculates the area of the triangle using Heron's formula.
     *
     * @return the area of the triangle
     */
    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    /**
     * Calculates the height of the triangle using Heron's formula.
     *
     * @return the height of the triangle
     */
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

    /**
     * Returns the detail of the triangle, including its sides, colour, and rotation status.
     *
             * @return a string describing the triangle
     */
    @Override
    public String toString() {
        return "Triangle [sides: " + side1 + ", " + side2 + ", " + side3 + ", colour: " + getColour() + ", rotation: " + currentRotation + " degrees]";
    }

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
