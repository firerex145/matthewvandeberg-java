import java.util.Arrays;
import java.util.Scanner;

public class RollDice {
    public static final int DICENUM = 1;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String[][] temp = defDice();
        String[][] gamedice = Arrays.copyOf(temp, temp.length * 2);

        String playAgain;
        int repeat = 0;
        while (repeat == 0){
            rollDice();
            printDice(temp);
            drawLine();
            System.out.println("Do you want to roll again? (y / n)");
            playAgain = input.next();
            if (playAgain.equalsIgnoreCase("no") || playAgain.equalsIgnoreCase("n")){
                repeat = 1;
            }
        }
    }
    public static String[][] defDice(){
        System.out.println("At defDice.");
        String[][] dice = new String[6][5];
        for (int i = 0; i < dice.length; i++){
            dice[i][0] = " ------- ";
            dice[i][4] = " ------- ";
        }
        dice[0][1] = "|       |";
        dice[0][2] = "|   *   |";
        dice[0][3] = "|       |";

        dice[1][1] = "|       |";
        dice[1][2] = "| *   * |";
        dice[1][3] = "|       |";

        dice[2][1] = "| *     |";
        dice[2][2] = "|   *   |";
        dice[2][3] = "|     * |";

        for (int i = 3; i < dice.length; i++) {
            dice[i][1] = "| *   * |";
            dice[i][3] = "| *   * |";
        }

        dice[3][2] = "|       |";

        dice[4][2] = "|   *   |";

        dice[5][2] = "| *   * |";

        return dice;
    }
    public static void rollDice(){
        //int roll;
        System.out.println("At rollDice.");
        //return roll;
    }
    public static void printDice(String[][] rolled){
        System.out.println("At printDice.");
        for (int i = 0; i < rolled.length; i++){
            for (int j = 0; j < rolled[0].length; j++){
                System.out.println(rolled[i][j]);
            }
        }
    }
    public static void drawLine(){
        System.out.println("At drawLine.");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
