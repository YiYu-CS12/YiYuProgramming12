import java.util.Scanner;

public class Quadrant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the x-coordinate:");
        double x = scanner.nextDouble();

        System.out.println("Enter the y-coordinate:");
        double y = scanner.nextDouble();

        if (x > 0 && y > 0) {
            System.out.println("Quadrant 1");
        } else if (x < 0 && y > 0) {
            System.out.println("Quadrant 2");
        } else if (x < 0 && y < 0) {
            System.out.println("Quadrant 3");
        } else if (x > 0 && y < 0) {
            System.out.println("Quadrant 4");
        } else if (x == 0 && y != 0) {
            System.out.println("On y-axis");
        } else if (x != 0 && y == 0) {
            System.out.println("On x-axis");
        } else {
            System.out.println("At the origin");
        }
        scanner.close();
    }
}