import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<TwoDShape> shapes = new ArrayList<>();
        shapes.add(new Triangle(3, 4, 5, Colour.RED));
        shapes.add(new Circle(5, Colour.BLUE));
        shapes.add(new Triangle(3, 8, Colour.GREEN));

        for (TwoDShape shape : shapes) {
            System.out.println(shape.toString());
            System.out.println("Area: " + shape.getArea());

            if (shape.getClass().getName().equals("Triangle")) {
                Rotate Tri = (Rotate) shape;
                Tri.rotate90();
                Tri.rotate180();
                Tri.rotate(45);
                System.out.println("Updated " + shape.toString());  // Display updated rotation status
            }
        }
    }
}
