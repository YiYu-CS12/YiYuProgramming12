// Some simple tests
public class Main {
    public static void main(String[] args) {
        TwoDShape test1 = new TwoDShape(3,5);
        System.out.println(test1.toString());
        System.out.println(test1.getArea());
        Triangle test2 = new Triangle(3,4);
        System.out.println(test2.toString());
        System.out.println(test2.getArea());
        Triangle test3 = new Triangle(3,5,6);
        System.out.println(test3.toString());
        System.out.println(test3.getArea());
    }
}