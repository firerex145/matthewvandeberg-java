import java.util.Scanner;

public class RollDice {
    public static final int DICENUM = 1000;
    static int rolls = 0;
    static String[][] gameDice = new String[DICENUM + 1][5 * DICENUM];
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String[][] temp = defDice();

        String playAgain;
        int repeat = 0;
        while (repeat == 0){
            rollDice(temp, gameDice);
            printDice(gameDice);
            drawLine();
            System.out.println("Do you want to roll again? (y / n)");
            playAgain = input.next();
            if (playAgain.equalsIgnoreCase("no") || playAgain.equalsIgnoreCase("n")){
                System.out.println();
                System.out.println("Number of times you rolled the dice: " + rolls);
                repeat = 1;
            }
        }
    }
    public static String[][] defDice(){
        System.out.println("At defDice.");
        String[][] dice = new String[6][5 * DICENUM];
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
    public static void rollDice(String[][] diceSet, String[][] rolledDice){
        System.out.println("At rollDice.");
        for (int i = 0; i < DICENUM; i++){
            int numberRoll = (int)(Math.random() * 6);
            for (int j = 0; j < 5 * DICENUM; j++){
                rolledDice[i][j] = diceSet[numberRoll][j];
            }
        }
        rolls++;
    }
    public static void printDice(String[][] rolled){
        System.out.println("At printDice.");
        for (int i = 0; i < rolled[0].length / DICENUM; i++){
            for (int j = 0; j < DICENUM; j++){
                System.out.print(rolled[j][i]);
            }
            System.out.println();
        }
    }
    public static void drawLine(){
        System.out.println("At drawLine.");
        for (int i = 0; i < DICENUM; i++) {
            System.out.print("------------------");
        }
        System.out.println();
    }
}
