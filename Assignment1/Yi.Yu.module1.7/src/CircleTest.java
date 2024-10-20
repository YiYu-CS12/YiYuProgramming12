import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {

    @org.junit.Test
    @Test
    public void testGetArea() {
        Circle circle1 = new Circle(5.0, Colour.RED);
        double expectedArea1 = 3.14159 * 5.0 * 5.0;
        assertEquals(expectedArea1, circle1.getArea());
        Circle circle2 = new Circle(7.5, Colour.RED);
        double expectedArea2 = 3.14159 * 7.5 * 7.5;
        assertEquals(expectedArea2, circle2.getArea());
    }
}