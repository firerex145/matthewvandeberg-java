import java.lang.reflect.Array;
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
    public static String add(int firstNume, int firstDenom, int secondNume, int secondDenom) {
        return "";
    }

    public static String subtract(int firstNume, int firstDenom, int secondNume, int secondDenom) {
        return "";
    }

    public static String multiply(int firstNume, int firstDenom, int secondNume, int secondDenom) {
        return "";
    }

    public static String divide(int firstNume, int firstDenom, int secondNume, int secondDenom) {
        return "";
    }

    public static void parse(String equation) {
        String[] arrayOfEquation = new String[3];
        arrayOfEquation = equation.split("");
        System.out.println(arrayOfEquation.toString());
    }
}