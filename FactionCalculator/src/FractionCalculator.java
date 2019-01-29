import java.util.Arrays;
import java.util.Scanner;

public class FractionCalculator {
    static int divisible = 0;
    static int wholeNum = 0;
    static int n = 2;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[] equationArray = new String[7];
        int loop = 0;
        while (loop == 0) {
            int inputLoop = 0;
            while (inputLoop == 0) {
                System.out.print("Enter something: ");
                String something = input.nextLine();
                if (something.contains("quit")) {
                    System.out.println("Program ended");
                    loop++;
                    inputLoop++;
                    break;
                } else {
                    equationArray = parse(something);
                }
                int error = 0;
                for (String i : equationArray){
                    if (i.matches("[;'.,<>?:{}|=_`~!@#$%^&()a-z/A-Z]")) {
                        error++;
                        break;
                    }
                }
                if (equationArray.length < 3 || equationArray.length > 8 || error == 1 || equationArray[0].matches("[-+*/ ]") || equationArray[equationArray.length - 1].matches("[-+*/ ]")) {
                    System.out.println("Invalid input.");
                } else {
                    inputLoop++;
                }
            }
            if (loop == 1){
                break;
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
            wholeNum = 0;
            n = 2;
            divisible = 0;
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

        while (divisible == 0) {
            if (n > numerator || n > denominator) {
                divisible++;
            }
            if (numerator % n == 0 && denominator % n == 0){
                while (numerator % n == 0 && denominator % n == 0) {
                    numerator = numerator / n;
                    denominator = denominator / n;
                }
            }
            n++;
        }

        if (numerator % denominator == 0) {
            numerator /= denominator;
            denominator /= denominator;
        } else if (denominator % numerator == 0) {
            denominator /= numerator;
            numerator /= numerator;
        }
        if (denominator == 1) {
            return numerator + "";
        }
        if (numerator > denominator) {
            int temp = numerator;
            while (temp - denominator > 0) {
                temp = temp - denominator;
                wholeNum++;
            }
            numerator = temp;
            return wholeNum + "_" + numerator + "/" + denominator;
        } else {
            return numerator + "/" + denominator;
        }
    }

    public static String subtract(int firstNume, int firstDenom, int secondNume, int secondDenom) {
        int numerator;
        int denominator;
        if (firstDenom == secondDenom) {
            System.out.println("equal denominators");
            numerator = firstNume - secondNume;
            denominator = firstDenom;
        } else {
            System.out.println("unequal denominators");
            numerator = (firstNume * secondDenom) - (secondNume * firstDenom);
            denominator = firstDenom * secondDenom;
        }
        if (denominator < 0) {
            System.out.println("negative denominator");
            denominator = Math.abs(denominator);
            numerator = -numerator;
        }
        if (numerator < 0 && denominator < 0) {
            System.out.println("negative fraction");
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
        if (numerator == denominator) {
            System.out.println("one");
            return "1";
        }

        while (divisible == 0) {
            System.out.println("divide");
            if (n > Math.abs(numerator) || n > denominator) {
                divisible++;
            }
            if (numerator % n == 0 && denominator % n == 0){
                while (numerator % n == 0 && denominator % n == 0) {
                    numerator = numerator / n;
                    denominator = denominator / n;
                }
            }
            n++;
        }
        System.out.println("simplified");

        if (numerator % denominator == 0) {
            numerator /= denominator;
            denominator /= denominator;
        } else if (denominator % numerator == 0) {
            denominator /= numerator;
            numerator /= numerator;
        }
        System.out.println("simplified between numerator and denominator");
        if (denominator == 1) {
            System.out.println("one after simplification");
            return numerator + "";
        }
        if (numerator > denominator) {
            System.out.println("numerator greater than denominator");
            int temp = numerator;
            while (Math.abs(temp - denominator) > 0) {
                if(temp < 0) {
                    temp += denominator;
                } else {
                    temp -= denominator;
                }
                wholeNum++;
            }
            if (numerator < 0) {
                wholeNum = -wholeNum;
            }
            numerator = temp;
            System.out.println("mixed number");
            return wholeNum + "_" + numerator + "/" + denominator;
        }
        System.out.println("return normal fraction");
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
        if (numerator == denominator) {
            return "1";
        }

        while (divisible == 0) {
            if (n > numerator || n > denominator) {
                divisible++;
            }
            if (numerator % n == 0 && denominator % n == 0){
                while (numerator % n == 0 && denominator % n == 0) {
                    numerator = numerator / n;
                    denominator = denominator / n;
                }
            }
            n++;
        }

        if (numerator % denominator == 0) {
            numerator /= denominator;
            denominator /= denominator;
        } else if (denominator % numerator == 0) {
            denominator /= numerator;
            numerator /= numerator;
        }
        if (denominator == 1) {
            return numerator + "";
        }
        if (numerator > denominator) {
            int temp = numerator;
            while (temp - denominator > 0) {
                temp = temp - denominator;
                wholeNum++;
            }
            numerator = temp;
            return wholeNum + "_" + numerator + "/" + denominator;
        } else {
            return numerator + "/" + denominator;
        }
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
        if (numerator == denominator) {
            return "1";
        }

        while (divisible == 0) {
            if (n > numerator || n > denominator) {
                divisible++;
            }
            if (numerator % n == 0 && denominator % n == 0){
                while (numerator % n == 0 && denominator % n == 0) {
                    numerator = numerator / n;
                    denominator = denominator / n;
                }
            }
            n++;
        }

        if (numerator % denominator == 0) {
            numerator /= denominator;
            denominator /= denominator;
        } else if (denominator % numerator == 0) {
            denominator /= numerator;
            numerator /= numerator;
        }
        if (denominator == 1) {
            return numerator + "";
        }
        if (numerator > denominator) {
            int temp = numerator;
            while (temp - denominator > 0) {
                temp = temp - denominator;
                wholeNum++;
            }
            numerator = temp;
            return wholeNum + "_" + numerator + "/" + denominator;
        } else {
            return numerator + "/" + denominator;
        }
    }

    public static String[] parse(String equation) {
        String[] arrayOfEquation = equation.split("[_/ ]");
        System.out.println(Arrays.toString(arrayOfEquation));
        return arrayOfEquation;
    }
}