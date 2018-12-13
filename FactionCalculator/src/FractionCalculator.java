import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int loop = 0;
        while (loop == 0) {
            System.out.print("Enter something: ");
            String something = input.nextLine();
            if (something.contains("quit")) {
                System.out.println("Program ended");
                loop++;
            } else {
                parse(something);
            }
        }
    }
    public static String add(final int firstNume, final int firstDenom, final int secondNume, final int secondDenom) {
        return "";
    }

    public static String subtract(final int firstNume, final int firstDenom, final int secondNume, final int secondDenom) {
        return "";
    }

    public static String multiply(final int firstNume, final int firstDenom, final int secondNume, final int secondDenom) {
        return "";
    }

    public static String divide(final int firstNume, final int firstDenom, final int secondNume, final int secondDenom) {
        return "";
    }

    public static void parse(final String equation) {
        ;
        return 0;
    }
}