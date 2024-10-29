public class Main {

    public static int seq1(int n) {
        if (n == 1) {
            return 25;
        }
        return seq1(n - 1) - 2;
    }

    public static int seq2(int n) {
        if (n == 1) {
            return 1;
        }
        return 2 * seq2(n - 1);
    }

    public static int seq3(int n) {
        if (n == 1 || n == 2) {
            return 2;
        }
        return seq3(n - 1) + seq3(n - 2);
    }

    public static int seq4(int n) {
        if (n == 1 || n == 2) {
            return 3;
        }
        return seq4(n - 1) + seq4(n - 2);
    }

    public static int seq5(int n) {
        if (n == 1) {
            return 1;
        }
        return n * seq5(n - 1);
    }

    public static void main(String[] args) {
        System.out.print("1.    ");
        for (int i = 1; i < 10; i++) {
            System.out.print(seq1(i) + " ");
        }
        System.out.println();

        System.out.print("2.    ");
        for (int i = 1; i < 10; i++) {
            System.out.print(seq2(i) + " ");
        }
        System.out.println();

        System.out.print("3.    ");
        for (int i = 1; i < 10; i++) {
            System.out.print(seq3(i) + " ");
        }
        System.out.println();

        System.out.print("4.    ");
        for (int i = 1; i < 10; i++) {
            System.out.print(seq4(i) + " ");
        }
        System.out.println();

        System.out.print("5.    ");
        for (int i = 1; i < 10; i++) {
            System.out.print(seq5(i) + " ");
        }
        System.out.println();
    }
}
