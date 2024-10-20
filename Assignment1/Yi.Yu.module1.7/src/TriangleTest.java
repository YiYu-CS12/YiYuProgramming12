import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    public void testGetArea() {
        Triangle triangle1 = new Triangle(3.0, 4.0, 5.0, Colour.BLUE);
        double expectedArea1 = 6.0;
        assertEquals(expectedArea1, triangle1.getArea());

        Triangle triangle2 = new Triangle(2.0, 2.0, 2.0, Colour.GREEN);
        double expectedArea2 = Math.sqrt(3.0) / 4.0 * 4.0;
        assertEquals(expectedArea2, triangle2.getArea());

        Triangle triangle4 = new Triangle(7.0, 8.0, Colour.NONE);
        double expectedArea4 = ( 7.0 * 8.0 ) / 2.0 ;
        assertEquals(expectedArea4, triangle4.getArea());
    }

    @Test
    public void testHeronsHeight() {
        Triangle triangle1 = new Triangle(3.0, 4.0, 5.0, Colour.RED);
        double expectedHeight1 = 4.0;
        assertEquals(expectedHeight1, triangle1.heronsHeight());

        Triangle triangle2 = new Triangle(2.0, 2.0, 2.0, Colour.GREEN);
        double expectedHeight2 = Math.sqrt(3.0);
        assertEquals(expectedHeight2, triangle2.heronsHeight());

        // Test height for an isosceles triangle with sides 5, 5, 8
        Triangle triangle3 = new Triangle(5.0, 5.0, 8.0, Colour.NONE);
        double area3 = triangle3.getArea();
        double expectedHeight3 = (2 * area3) / 5;
        assertEquals(expectedHeight3, triangle3.heronsHeight());
    }
}