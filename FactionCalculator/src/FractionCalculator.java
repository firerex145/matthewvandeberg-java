import java.util.Arrays;
import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[] equationArray = new String[7];
        int loop = 0;
        while (loop == 0) {
            System.out.print("Enter something: ");
            String something = input.nextLine();
            if (something.contains("quit")) {
                System.out.println("Program ended");
                loop++;
            } else {
                equationArray = parse(something);
            }

            int firstNume;
            int firstDenom;
            if (equationArray[3].equals("+") || equationArray[3].equals("-") || equationArray[3].equals("*") || equationArray[3].equals("")) {
                firstNume = (Integer.parseInt(equationArray[2]) * Integer.parseInt(equationArray[0]) + Integer.parseInt(equationArray[1]));
                firstDenom = Integer.parseInt(equationArray[2]);
                equationArray[0] = "0";
            } else {
                firstNume = Integer.parseInt(equationArray[0]);
                if (equationArray[1].equals("+") || equationArray[1].equals("-") || equationArray[1].equals("*") || equationArray[1].equals("")) {
                    firstDenom = 1;
                } else {
                    firstDenom = Integer.parseInt(equationArray[1]);
                }
            }
            String operator = "";
            int operatorIndex = 0;
            for (int i = 1; i < 4; i++) {
                if (equationArray[i].equals("+") || equationArray[i].equals("-") || equationArray[i].equals("*") || equationArray[i].equals("")) {
                    operator = equationArray[i];
                    operatorIndex = i;
                }
            }
            int secondNume;
            int secondDenom;
            if ((operatorIndex + 1) == (equationArray.length - 1)) {
                secondNume = Integer.parseInt(equationArray[operatorIndex + 1]);
                secondDenom = 1;
            } else if ((operatorIndex + 1) == (equationArray.length - 2)) {
                secondNume = Integer.parseInt(equationArray[operatorIndex + 1]);
                secondDenom = Integer.parseInt(equationArray[equationArray.length - 1]);
            } else {
                secondNume = Integer.parseInt(equationArray[equationArray.length - 1]) * Integer.parseInt(equationArray[operatorIndex + 1]) + Integer.parseInt(equationArray[operatorIndex + 2]);
                secondDenom = Integer.parseInt(equationArray[equationArray.length - 1]);
            }
            if (operator.equals("+")) {
                System.out.println(add(firstNume, firstDenom, secondNume, secondDenom));
            } else if (operator.equals("-")) {
                System.out.println(subtract(firstNume, firstDenom, secondNume, secondDenom));
            } else if (operator.equals("*")) {
                System.out.println(multiply(firstNume, firstDenom, secondNume, secondDenom));
            } else {
                System.out.println(divide(firstNume, firstDenom, secondNume, secondDenom));
            }
        }
    }

    public static String add(int firstNume, int firstDenom, int secondNume, int secondDenom) {
        int Numerator;
        int Denominator;
        if (firstDenom == secondDenom) {
            Numerator = firstNume + secondNume;
            Denominator = firstDenom;
        } else {
            Numerator = (firstNume * secondDenom) + (secondNume * firstDenom);
            Denominator = firstDenom * secondDenom;
        }
        return Numerator + "/" + Denominator;
    }

    public static String subtract(int firstNume, int firstDenom, int secondNume, int secondDenom) {
        int Numerator;
        int Denominator;
        if (firstDenom == secondDenom) {
            Numerator = firstNume - secondNume;
            Denominator = firstDenom;
        } else {
            Numerator = (firstNume * secondDenom) - (secondNume * firstDenom);
            Denominator = firstDenom * secondDenom;
        }
        return Numerator + "/" + Denominator;
    }

    public static String multiply(int firstNume, int firstDenom, int secondNume, int secondDenom) {
        int Numerator = firstNume * secondNume;
        int Denominator = firstDenom * secondDenom;
        return Numerator + "/" + Denominator;
    }

    public static String divide(int firstNume, int firstDenom, int secondNume, int secondDenom) {
        int Numerator = firstNume * secondDenom;
        int Denominator = firstDenom * secondNume;
        return Numerator + "/" + Denominator;
    }

    public static String[] parse(String equation) {
        String[] arrayOfEquation = equation.split("[_/ ]");
        System.out.println(Arrays.toString(arrayOfEquation));
        return arrayOfEquation;
    }
}