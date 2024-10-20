class Circle extends TwoDShape {
    private static final double PI = 3.14159;
    private double radius;

    /**
     * Constructs a Circle with a given radius and colour.
     * The width and height of the shape are set to twice the radius.
     *
     * @param radius the radius of the circle
     * @param colour the colour of the circle
     */
    public Circle(double radius, Colour colour) {
        super(radius * 2, radius * 2, colour);
        this.radius = radius;
    }

    /**
     * Calculates and returns the area of the circle.
     * The area is computed using the formula: π * radius^2.
     *
     * @return the area of the circle
     */
    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    // Get/Set Methods
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
        setWidth(radius * 2);
        setHeight(radius * 2);
    }

    /**
     * Returns a string representation of the circle, including its radius and colour.
     *
     * @return a string describing the circle
     */
    @Override
    public String toString() {
        return "Circle [radius: " + radius + ", colour: " + getColour() + "]";
    }
}
