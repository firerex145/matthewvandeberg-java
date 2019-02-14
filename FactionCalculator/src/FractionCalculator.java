/*
Matthew Vandeberg
AP CS A
Period 1
2-13-19
FractionCalculator
 */

import java.util.Arrays;
import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //create a scanner to read input
        String[] equationArray = new String[7]; //create an array to store the equation given by the user

        int loop = 0;                           //looper variable (keep program running)
        while (loop == 0) {                     //------------------^ (arrow pointing up)
            int inputLoop = 0;        //looper inside looper to catch input error
            while (inputLoop == 0) {  // ^--- what that says ---^
                System.out.print("\nEnter an equation or enter quit to exit: \n"); //prompting user to enter equation or quit
                String userInput = input.nextLine(); //turn input into a string object
                if (userInput.contains("quit")) { //if the user input contains "quit"
                    System.out.println("Program ended"); //tell user the program has quit
                    loop++;      // (see below)
                    inputLoop++; //  end looper
                    break;       // (see above)
                } else { //if user does not quit
                    equationArray = parse(userInput); //send input to "parse" method and assign the returned array to the equation array
                }

                int error = 0; //integer used to track any errors

                for (String i : equationArray) { //for-each loop that goes through equationArray
                    if (i.matches("[;'.,<>?:{}|=_`~!@#$%^&()a-zA-Z]null")) { //checks if an element of equationArray is an invalid character or is null
                        error++; //flags input for having an error
                        break; //stops "for" loop
                    }
                }
                if (equationArray.length < 3 || equationArray.length > 8 || error == 1 || equationArray[0].matches("[-+*/ ]") || equationArray[equationArray.length - 1].matches("[-+*/ ]") || equationArray.length == 3 && !(equationArray[1].matches("[-+*/]"))) { //checks for more irregularities and if there is a previously reported error
                    System.out.println("Invalid input."); //tells user that there input was bad
                } else { //no errors found
                    inputLoop++; //stops the error checking loop
                }
            }
            if (loop == 1) { //checks if the user said "quit"
                break; //break the looper and end the program
            }

            //following code finds the operator in equation
            String operator = ""; //make variable to store operator (+, -, *, /)
            int operatorIndex = 0; //make variable to store index of operator (used later)
            for (int i = 1; i < 4; i++) { //for loop to find operator and index
                if (equationArray[i].equals("+") || equationArray[i].equals("-") || equationArray[i].equals("*") || equationArray[i].equals("/")) {
                    operator = equationArray[i]; //assign operator to operator variable
                    operatorIndex = i; //retrieve operator index
                    i = 4; //end "for" loop
                }
            }

            //following code determines first fraction in equation
            int firstNume; //variable for the first fraction's numerator
            int firstDenom; //variable for the first fraction's denominator
            if (equationArray[1].equals("+") || equationArray[1].equals("-") || equationArray[1].equals("*") || equationArray[1].equals("/")) { //runs if the first operand is a whole number
                firstNume = Integer.parseInt(equationArray[0]); //assigns the whole number to the first numerator
                firstDenom = 1; //makes first denominator 1 turning the whole number into an improper fraction
            } else if (equationArray[3].equals("+") || equationArray[3].equals("-") || equationArray[3].equals("*") || equationArray[3].equals("/")) { //runs if the first operand is a mixed number
                if (Integer.parseInt(equationArray[0]) < 0) { //if the whole number in the mixed number is negative
                    firstNume = (Integer.parseInt(equationArray[2]) * Integer.parseInt(equationArray[0]) - Integer.parseInt(equationArray[1])); //turns negative mixed number into negative improper fraction (numerator calculations only)
                } else { //if whole number is positive
                    firstNume = (Integer.parseInt(equationArray[2]) * Integer.parseInt(equationArray[0]) + Integer.parseInt(equationArray[1])); //turns mixed number into improper fraction (numerator calculations only)
                }
                firstDenom = Integer.parseInt(equationArray[2]); //retrieve denominator of improper fraction
                equationArray[0] = "0"; //replaces whole number with a zero just to be safe
            } else { //if first operand is a normal fraction
                firstNume = Integer.parseInt(equationArray[0]); //assign first number to first numerator
                firstDenom = Integer.parseInt(equationArray[1]); //assign second number to first denominator
            }

            //following code determines second fraction in equation
            int secondNume; //variable for second fraction's numerator
            int secondDenom; //variable for second fraction's denominator
            if ((operatorIndex + 1) == (equationArray.length - 1)) { //runs if the second operand is a whole number
                secondNume = Integer.parseInt(equationArray[operatorIndex + 1]); //assign whole number to be second fraction's numerator
                secondDenom = 1; //make second fraction's denominator 1
            } else if ((operatorIndex + 1) == (equationArray.length - 2)) { //runs if the second operand is a normal fraction
                secondNume = Integer.parseInt(equationArray[operatorIndex + 1]); //assigns number after the operator to be second fraction's numerator
                secondDenom = Integer.parseInt(equationArray[equationArray.length - 1]); //assigns the last number in array as denominator of second fraction
            } else { //runs if the second operand is a mixed number
                if (Integer.parseInt(equationArray[operatorIndex + 1]) < 0) { //if the whole number in the mixed number is negative
                    secondNume = Integer.parseInt(equationArray[equationArray.length - 1]) * Integer.parseInt(equationArray[operatorIndex + 1]) - Integer.parseInt(equationArray[operatorIndex + 2]); //turns negative mixed number into negative improper fraction (numerator calculations only)
                    secondDenom = Integer.parseInt(equationArray[equationArray.length - 1]); //assigns last number in array as second fraction's denominator
                } else { //if whole number is positive
                    secondNume = Integer.parseInt(equationArray[equationArray.length - 1]) * Integer.parseInt(equationArray[operatorIndex + 1]) + Integer.parseInt(equationArray[operatorIndex + 2]); //turns mixed number into improper fraction (numerator calculations only)
                    secondDenom = Integer.parseInt(equationArray[equationArray.length - 1]); //assigns last number in array as second fraction's denominator
                }
            }

            //series of if statements (imagine it like a switch statement) that reads the operator and determines the operation then sends the fractions to be calculated to the proper methods then prints results
            if (operator.equals("+")) {
                System.out.println(add(firstNume, firstDenom, secondNume, secondDenom)); //prints out the calculated and simplified version of the two fractions
            } else if (operator.equals("-")) {
                System.out.println(subtract(firstNume, firstDenom, secondNume, secondDenom)); //prints out the calculated and simplified version of the two fractions
            } else if (operator.equals("*")) {
                System.out.println(multiply(firstNume, firstDenom, secondNume, secondDenom)); //prints out the calculated and simplified version of the two fractions
            } else {
                System.out.println(divide(firstNume, firstDenom, secondNume, secondDenom)); //prints out the calculated and simplified version of the two fractions
            }
        }
    }

    //adds the fractions
    public static String add(int firstNume, int firstDenom, int secondNume, int secondDenom) { //takes the numerators and denominators determined earlier as parameters
        int numerator; //variable to store calculated numerator
        int denominator; //variable to store calculated denominator
        if (firstDenom == secondDenom) { //runs if the denominators are equal
            numerator = firstNume + secondNume; //adds the numerators together
            denominator = firstDenom; //sets the denominator to the denominators of the original fractions
        } else { //runs if denominators are unequal
            numerator = (firstNume * secondDenom) + (secondNume * firstDenom); //multiplying numerators by denominators of other fraction then adding them together
            denominator = firstDenom * secondDenom; //make the denominators equal then assign that value to the final denominator variable
        }

        return simplify(numerator, denominator); //send the calculated fraction to be simplified in the "simplify" method then returns the results
    }

    //subtracts the fractions
    public static String subtract(int firstNume, int firstDenom, int secondNume, int secondDenom) { //takes the numerators and denominators determined earlier as parameters
        int numerator; //variable to store calculated numerator
        int denominator; //variable to store calculated denominator
        if (firstDenom == secondDenom) { //runs if the denominators are equal
            numerator = firstNume - secondNume; //subtracts the numerators
            denominator = firstDenom; //sets the denominator to the denominators of the original fractions
        } else { //runs if denominators are unequal
            numerator = (firstNume * secondDenom) - (secondNume * firstDenom); //multiplying numerators by denominators of other fraction then subtracting them
            denominator = firstDenom * secondDenom; //make the denominators equal then assign that value to the final denominator variable
        }

        return simplify(numerator, denominator); //send the calculated fraction to be simplified in the "simplify" method then returns the results
    }

    //multiplies the fractions
    public static String multiply(int firstNume, int firstDenom, int secondNume, int secondDenom) { //takes the numerators and denominators determined earlier as parameters
        int numerator = firstNume * secondNume; //multiplies the two numerators
        int denominator = firstDenom * secondDenom; //multiplies the two denominators

        return simplify(numerator, denominator); //send the calculated fraction to be simplified in the "simplify" method then returns the results
    }

    //divides the fractions
    public static String divide(int firstNume, int firstDenom, int secondNume, int secondDenom) { //takes the numerators and denominators determined earlier as parameters
        int numerator = firstNume * secondDenom; //divides the two numerators
        int denominator = firstDenom * secondNume; //divides the two denominators

        return simplify(numerator, denominator); //send the calculated fraction to be simplified in the "simplify" method then returns the results
    }

    //simplifies the calculated fractions
    public static String simplify(int numerator, int denominator) { //takes the calculated numerator and denominator as parameters
        int divisible = 0; //variable used to track divisibility of fraction
        int wholeNum = 0; //variable used to store the whole number when turning improper fractions into mixed numbers
        int n = 2; //used when simplifying fraction

        if (numerator == denominator) { //returns 1 if the numerator and denominator are the same number
            return "Result: 1";
        }

        if (numerator % denominator == 0) { //if numerator is evenly divisible by the denominator
            numerator /= denominator; //divides the numerator by the denominator
            denominator /= denominator; //divides the denominator by itself
        } else if (denominator % numerator == 0) { //if the denominator is divisible by the numerator
            denominator /= numerator; //divide the denominator by the numerator
            numerator /= numerator; //divide the numerator by itself
        }

        while (divisible == 0) { //looper that divides the fraction by increasing numbers starting at 2 until it is in its simplest state

            if (n > Math.abs(numerator) || n > denominator) { //checks to see if either the numerator or denominator is smaller than the (dividing number) -> (n)
                divisible++; //ends the divider loop if the dividing number is greater than either the numerator or denominator
            }

            if (numerator % n == 0 && denominator % n == 0){ //runs if the numerator or denominator is evenly divisible by the dividing number

                while (numerator % n == 0 && denominator % n == 0) { //runs for as long as the numerator and denominator are divisible by the dividing number
                    numerator = numerator / n; //divides the numerator by the dividing number
                    denominator = denominator / n; //divides the denominator by the same number as the numerator
                }

            }
            n++; //increases the value of the dividing number
        }

        if (numerator < 0 && denominator < 0) { //turns the numerator and denominator into positive numbers if both are negative
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }

        if (denominator < 0) { //turns the numerator into a negative number and the denominator into a positive number if just the denominator is negative
            denominator = Math.abs(denominator);
            numerator = -numerator;
        }

        if (denominator == 1) { //returns just the numerator if the denominator is one (indicates whole number)
            return "Result: " + numerator + "";
        }

        //essentially just repeated subtraction to obtain a whole number and the new numerator of a fraction to turn an improper fraction into a mixed number
        if (Math.abs(numerator) > denominator) { //runs if the numerator is greater than the denominator
            int temp = Math.abs(numerator); //temporary variable that stores the absolute value of the numerator

            while (temp - denominator > 0) { //runs while the difference between temp and the denominator
                if(temp < 0) { //runs if temp is negative (shouldn't ever be, just a safeguard)
                    temp += denominator; //add the value of the denominator the temp
                } else { //runs if temp is positive
                    temp -= denominator; //subtracts the value of denominator from temp
                }
                wholeNum++; //adds one to the whole number for each time the while loop is run
            }

            if (numerator < 0) { //if the numerator was, negative turn the whole number negative
                wholeNum = -wholeNum;
            }
            numerator = temp; //assign the value calculated above (and stored in temp) to the numerator

            return "Result: " + wholeNum + "_" + numerator + "/" + denominator; //return the simplified mixed number
        }

        return "Result: " + numerator + "/" + denominator; //return the simplified fraction if it is not a mixed number
    }

    //picks out the useful parts of the user's input
    public static String[] parse(String equation) { //returns an array of strings and accepts a string as a parameter
        String[] arrayOfEquation = equation.split("[_/ a-zA-z.]"); //turn the user input into an array splitting the string every time there is an _ or / or space or a letter (letter is used for error checking)

        for (int i = 0; i < arrayOfEquation.length; i++) {                                                //
            if (arrayOfEquation[i].equals("")) {                                                          //
                arrayOfEquation[i] = "/";                                                                 //
                for (int j = 1; j < arrayOfEquation.length - (i + 1); j++) {                              //this section corrects the array when
                    arrayOfEquation[i + j] = arrayOfEquation[i + 1 + j];                                  //the user is doing division as the .split method removes
                }                                                                                         //the division operator and adds an extra space in the array
                arrayOfEquation = Arrays.copyOf(arrayOfEquation, arrayOfEquation.length - 1);   //
            }                                                                                             //
        }                                                                                                 //

        return arrayOfEquation; //returns the user input as an array of whole numbers, numerators, denominators, and an operator (not in that order)
    }
}