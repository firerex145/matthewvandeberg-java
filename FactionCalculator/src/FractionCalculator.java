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

            String operator = "";
            int operatorIndex = 0;
            int divide = 0;
            for (int i = 1; i < 4; i++) {
                if (equationArray[i].equals("+") || equationArray[i].equals("-") || equationArray[i].equals("*") || equationArray[i].equals("")) {
                    operator = equationArray[i];
                    operatorIndex = i;
                    if (equationArray[i].equals("")) {
                        equationArray[i] = "/";
                        equationArray[i + 1] = equationArray[i + 2];
                        equationArray[i + 2] = equationArray[equationArray.length - 1];
                        divide++;
                    }
                    i = 4;
                }
            }
            int firstNume;
            int firstDenom;
            if (equationArray[1].equals("+") || equationArray[1].equals("-") || equationArray[1].equals("*") || equationArray[1].equals("/")) {
                firstDenom = 1;
                firstNume = Integer.parseInt(equationArray[0]);
            } else if (equationArray[3].equals("+") || equationArray[3].equals("-") || equationArray[3].equals("*") || equationArray[3].equals("/")) {
                if (Integer.parseInt(equationArray[0]) < 0) {
                    firstNume = (Integer.parseInt(equationArray[2]) * Integer.parseInt(equationArray[0]) - Integer.parseInt(equationArray[1]));
                } else {
                    firstNume = (Integer.parseInt(equationArray[2]) * Integer.parseInt(equationArray[0]) + Integer.parseInt(equationArray[1]));
                }
                firstDenom = Integer.parseInt(equationArray[2]);
                equationArray[0] = "0";
            } else {
                firstNume = Integer.parseInt(equationArray[0]);
                firstDenom = Integer.parseInt(equationArray[1]);
            }
            int secondNume;
            int secondDenom;
            if (divide == 1) {
                if ((operatorIndex + 1) == (equationArray.length - 2)) {
                    secondNume = Integer.parseInt(equationArray[operatorIndex + 1]);
                    secondDenom = 1;
                } else if ((operatorIndex + 1) == (equationArray.length - 3)) {
                    secondNume = Integer.parseInt(equationArray[operatorIndex + 1]);
                    secondDenom = Integer.parseInt(equationArray[equationArray.length - 2]);
                } else {
                    secondNume = Integer.parseInt(equationArray[equationArray.length - 2]) * Integer.parseInt(equationArray[operatorIndex + 1]) + Integer.parseInt(equationArray[operatorIndex + 2]);
                    secondDenom = Integer.parseInt(equationArray[equationArray.length - 2]);
                }
            } else if ((operatorIndex + 1) == (equationArray.length - 1)) {
                secondNume = Integer.parseInt(equationArray[operatorIndex + 1]);
                secondDenom = 1;
            } else if ((operatorIndex + 1) == (equationArray.length - 2)) {
                secondNume = Integer.parseInt(equationArray[operatorIndex + 1]);
                secondDenom = Integer.parseInt(equationArray[equationArray.length - 1]);
            } else {
                secondNume = Integer.parseInt(equationArray[equationArray.length - 1]) * Integer.parseInt(equationArray[operatorIndex + 1]) + Integer.parseInt(equationArray[operatorIndex + 2]);
                secondDenom = Integer.parseInt(equationArray[equationArray.length - 1]);
            }
            System.out.println(firstNume + "/" + firstDenom + " " + secondNume + "/" + secondDenom);
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
        int numerator;
        int denominator;
        if (firstDenom == secondDenom) {
            numerator = firstNume + secondNume;
            denominator = firstDenom;
        } else {
            numerator = (firstNume * secondDenom) + (secondNume * firstDenom);
            denominator = firstDenom * secondDenom;
        }
        if (denominator < 0) {
            denominator = Math.abs(denominator);
            numerator = -numerator;
        }
        if (numerator < 0 && denominator < 0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
        if (numerator == denominator) {
            return "1";
        }
        return numerator + "/" + denominator;
    }

    public static String subtract(int firstNume, int firstDenom, int secondNume, int secondDenom) {
        int numerator;
        int denominator;
        if (firstDenom == secondDenom) {
            numerator = firstNume - secondNume;
            denominator = firstDenom;
        } else {
            numerator = (firstNume * secondDenom) - (secondNume * firstDenom);
            denominator = firstDenom * secondDenom;
        }
        if (denominator < 0) {
            denominator = Math.abs(denominator);
            numerator = -numerator;
        }
        if (numerator < 0 && denominator < 0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
        if (numerator == denominator) {
            return "1";
        }
        return numerator + "/" + denominator;
    }

    public static String multiply(int firstNume, int firstDenom, int secondNume, int secondDenom) {
        int numerator = firstNume * secondNume;
        int denominator = firstDenom * secondDenom;
        if (denominator < 0) {
            denominator = Math.abs(denominator);
            numerator = -numerator;
        }
        if (numerator < 0 && denominator < 0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
        if (denominator == 1) {
            return numerator + "";
        }
        if (numerator == denominator) {
            return "1";
        }
        return numerator + "/" + denominator;
    }

    public static String divide(int firstNume, int firstDenom, int secondNume, int secondDenom) {
        int numerator = firstNume * secondDenom;
        int denominator = firstDenom * secondNume;
        if (denominator < 0) {
            denominator = Math.abs(denominator);
            numerator = -numerator;
        }
        if (numerator < 0 && denominator < 0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
        if (denominator == 1) {
            return numerator + "";
        }
        if (numerator == denominator) {
            return "1";
        }
        return numerator + "/" + denominator;
    }

    public static String[] parse(String equation) {
        String[] arrayOfEquation = equation.split("[_/ ]");
        System.out.println(Arrays.toString(arrayOfEquation));
        return arrayOfEquation;
    }
}