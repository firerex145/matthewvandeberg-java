public class ParameterMath {
    public static void main(String[] args) {
        System.out.println(add(2, 4));
        System.out.println(minimum(3, 6, 1));
        System.out.println(squareRoot(3, 4, 13));
    }
    public static int add(int a, int b) {
        return (a + b);
    }
    public static int minimum(int a, int b, int c) {
        return(Math.min(a, Math.min(b, c)));
    }
    public static double squareRoot(int a, int b, int c) {
        return(Math.sqrt((Math.min(a, Math.min(b, c)) + Math.max(a, Math.max(b, c)))));
    }
}
