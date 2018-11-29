import java.util.Scanner;

public class RollDice {
    public static final int DICENUM = 1;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String playAgain = "";
        int repeat = 0;
        defDice();
        while (repeat == 0){
            rollDice();
            printDice();
            drawLine();
            System.out.println("Do you want to roll again? (y / n)");
            playAgain = input.next();
            if (playAgain.equalsIgnoreCase("no") || playAgain.equalsIgnoreCase("n")){
                repeat = 1;
            }
        }
    }
    public static void defDice(){
        System.out.println("At defDice.");
    }
    public static void rollDice(){
        //int roll;
        System.out.println("At rollDice.");
        //return roll;
    }
    public static void printDice(){
        System.out.println("At printDice.");
    }
    public static void drawLine(){
        System.out.println("At drawLine.");
    }
}
