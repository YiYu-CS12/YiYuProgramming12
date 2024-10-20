public class Main {
    public static void main(String[] args) {
        Triangle testTri = new Triangle(3, 4, 5);
        testTri.rotate90();
        System.out.println(testTri.toString());
        testTri.rotate180();
        System.out.println(testTri.toString());
        testTri.rotate(45);
        System.out.println(testTri.toString());
        System.out.println("Updated " + testTri.toString());
    }
}