abstract class TwoDShape {
    private double width;
    private double height;
    private Colour colour;

    /**
     * Constructs a TwoDShape with specified width, height, and colour.
     *
     * @param width  the width of the shape
     * @param height the height of the shape
     * @param colour the colour of the shape
     */
    public TwoDShape(double width, double height, Colour colour) {
        this.width = width;
        this.height = height;
        this.colour = colour;
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
    public Colour getColour() {
        return colour;
    }
    public void setColour(Colour colour) {
        this.colour = colour;
    }

    // Abstract method for area
    public abstract double getArea();

    /**
     * Returns a string representation of the shape, including its width, height, and colour.
     *
     * @return a string describing the shape
     */
    @Override
    public String toString() {
        return "Shape [width: " + width + ", height: " + height + ", colour: " + colour + "]";
    }
}
