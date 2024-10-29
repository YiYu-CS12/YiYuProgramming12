
public class Main {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 9;
        int result = fibonacci(n);
        System.out.println("The " + n + "-th Fibonacci number is: " + result);
        n = 2;
        result = fibonacci(n);
        System.out.println("The " + n + "-th Fibonacci number is: " + result);
    }
}