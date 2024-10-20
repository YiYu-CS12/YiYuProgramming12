import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<TwoDShape> shapes = new ArrayList<>();
        shapes.add(new Triangle(3, 4, 5));
        shapes.add(new Circle(5));

        for (TwoDShape shape : shapes) {
            System.out.println(shape.toString());
            System.out.println("Area: " + shape.getArea());
        }
    }
}
