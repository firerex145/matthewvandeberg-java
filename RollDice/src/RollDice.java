import java.util.Scanner;

public class RollDice {
    public static final int DICENUM = 1; //Class constant used to tell program how many dice to "roll".

    static int rolls = 0; //Variable used to track number of times dice are rolled.

    static String[][] gameDice = new String[DICENUM + 1][5 * DICENUM]; //Multidimensional array of Strings used to store the dice that has been rolled.

    public static void main(String[] args){
        Scanner input = new Scanner(System.in); //Scanner used to get input from the user.

        String[][] temp = defDice(); //Creates an array, temp, that has the values of the array returned by the defDice method after bring run.

        String playAgain; //Creates a new String object called playAgain.

        int repeat = 0; //An integer used to keep the program running
        while (repeat == 0){ //A loop that runs while repeat has a value of zero.

            rollDice(temp, gameDice); //Passes the arrays temp and gameDice to the method rollDice.
            printDice(gameDice); //Passes gameDice array to printDice method.
            drawLine(); //Draws a line between each roll.

            System.out.println("Do you want to roll again? (y / n)"); //Asks the user if they want to "roll" dice again.
            playAgain = input.next(); //Assigns answer to String playAgain.

            if (playAgain.equalsIgnoreCase("no") || playAgain.equalsIgnoreCase("n")){ //Runs if user doesn't want to roll again.
                System.out.println();
                System.out.println("Number of times you rolled the dice: " + rolls); //Prints how many times dice were "rolled."

                repeat = 1; //Stops the while loop and ends program.
            }
        }
    }

    public static String[][] defDice(){ //Makes a graphical representation of each face of a six-sided die.
        //System.out.println("At defDice.");

        String[][] dice = new String[6][5 * DICENUM]; //Creates multidimensional array, dice, that stores a graphical version of each face of a die.

        for (int i = 0; i < dice.length; i++){ //For loop that assigns a top and bottom to each die face.
            dice[i][0] = " ------- ";
            dice[i][4] = " ------- ";
        }

        dice[0][1] = "|       |"; //
        dice[0][2] = "|   *   |"; //Puts the rest of the first face into the array.
        dice[0][3] = "|       |"; //

        dice[1][1] = "|       |"; //
        dice[1][2] = "| *   * |"; //Puts the rest of the second face into the array.
        dice[1][3] = "|       |"; //

        dice[2][1] = "| *     |"; //
        dice[2][2] = "|   *   |"; //Puts the rest of the third face into the array.
        dice[2][3] = "|     * |"; //

        for (int i = 3; i < dice.length; i++) { //For loop that puts the upper and lower rows of the fourth, fifth, and sixth face into the array.
            dice[i][1] = "| *   * |";
            dice[i][3] = "| *   * |";
        }

        dice[3][2] = "|       |"; //Puts the middle of the fourth face into the array.

        dice[4][2] = "|   *   |"; //Puts the middle of the fifth face into the array.

        dice[5][2] = "| *   * |"; //Puts the middle of the sixth face into the array.

        return dice; //Returns the array, dice, now filled with a graphical representation of each face of a six-sided die.
    }

    public static void rollDice(String[][] diceSet, String[][] rolledDice){ //"Rolls" the number of dice according to value of DICENUM.
        //System.out.println("At rollDice.");

        for (int i = 0; i < DICENUM; i++){
            int numberRoll = (int)(Math.random() * 6); //Assign a random number between one and six the variable numberRoll.
            for (int j = 0; j < 5 * DICENUM; j++){
                rolledDice[i][j] = diceSet[numberRoll][j]; //Assigns one die face to an array in rolledDice (gameDice) based on value of numberRoll.
            }
        }
        rolls++; //Adds one to the total number of times the dice have been rolled.
    }

    public static void printDice(String[][] rolled){ //prints the graphical representation of the "rolled" dice.
        //System.out.println("At printDice.");
        for (int i = 0; i < rolled[0].length / DICENUM; i++){
            for (int j = 0; j < DICENUM; j++){
                System.out.print(rolled[j][i]);
            }
            System.out.println();
        }
    }
    public static void drawLine(){ //Draws a line between the "rolls" who's length is determined by the amount of dice being "rolled."
        //System.out.println("At drawLine.");
        for (int i = 0; i < DICENUM; i++) {
            System.out.print("------------------");
        }
        System.out.println();
    }
}
