public class PrintStars {
    public static void main(String[] args) {
        int n = 5;
        iterativePrintStars(n);
        recursivePrintStars(n);
    }
    public static void iterativePrintStars(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("*");
        }
        System.out.println();
    }
    public static void recursivePrintStars(int n) {
        if (n > 0) {
            System.out.println("*");
            recursivePrintStars(n - 1);
        }
    }
}
