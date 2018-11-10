import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    static Scanner player = new Scanner(System.in);
    static String name;
    public static void main(String[] args){
        int humanGames = 0;
        int compGames = 0;
        int playAgain = 0;
        int games = 1;
        Random rand = new Random();
        String rematch;
        System.out.println("What is your name?");
        name = player.next();
        while(playAgain == 0) {
            int humanWins = 0;
            int compWins = 0;
            int ties = 0;
            int rematchPrompt = 0;
            System.out.println("Would you like to play three or five rounds?");
            int rounds = player.nextInt();
            while (!(rounds == 3 || rounds == 5)) {
                System.out.println("You can only play three or five rounds. Re-enter how many rounds you want to play.");
                rounds = player.nextInt();
            }
            while(rounds > 0 - ties){
                System.out.println("Enter 0 (rock), 1 (paper), or 2 (scissors).");
                int input = player.nextInt();
                int compInput = rand.nextInt(3);
                String roundResults = play(input, compInput);
                System.out.println(roundResults + "\n");
                if (roundResults.endsWith("WINS\033[0;0m") == true) {
                    humanWins++;
                } else if (roundResults.endsWith("LOSES\033[0;0m") == true) {
                    compWins++;
                } else {
                    ties++;
                }
                System.out.print("Match Standings: ");
                System.out.printf(name + " wins -- %2s  Computer wins -- %2s  Ties -- %2s\n\n", humanWins, compWins, ties);
                rounds--;
            }
            if (humanWins > compWins) {
                System.out.println("game " + games + " results: " + name + " beats computer " + humanWins + " to " + compWins);
                humanGames++;
            } else {
                System.out.println("game " + games + " results: computer beats " + name + " " + compWins + " to " + humanWins);
                compGames++;
            }
            System.out.printf("Overall standings: " + name + " -- %2s wins Computer -- %2s wins\n", humanGames, compGames);
            System.out.println("Rematch? (yes/no)");
            rematch = player.next();
            while (rematchPrompt == 0) {
                if (rematch.equalsIgnoreCase("yes")) {
                    games++;
                    rematchPrompt++;
                } else if (rematch.equalsIgnoreCase("no")) {
                    playAgain = 1;
                    rematchPrompt++;
                } else {
                    System.out.println("Please answer with yes or no");
                    rematch = player.next();
                }
            }
        }
    }
    public static String play(int playerInput, int compInput){
        String human;
        String computer;
        while(playerInput > 2 || playerInput < 0){
            System.out.println("You have to choose a number between 0-2 for your input. Please re-enter selection");
            playerInput = player.nextInt();
        }
        if (playerInput == 0){
            human = "rock";
        } else if (playerInput == 1){
            human = "paper";
        } else {
            human = "scissors";
        }
        if (compInput == 0){
            computer = "rock";
        } else if (compInput == 1){
            computer = "paper";
        } else {
            computer = "scissors";
        }
        return(results(human, computer));
    }
    public static String results(String humanChoice, String compChoice){
        System.out.println("Rock, Paper, Scissors; Shoot!\n");
        System.out.printf(name + " chooses: %10s\n", humanChoice);
        System.out.printf("Computer chooses: %10s\n", compChoice);
        if (humanChoice.equals("paper") && compChoice.equals("rock") || humanChoice.equals("rock") && compChoice.equals("scissors") || humanChoice.equals("scissors") && compChoice.equals("paper")){
            return(humanChoice + " beats " + compChoice + " -- " + name + "\033[0;32m WINS\033[0;0m");
        } else if(compChoice.equals("paper") && humanChoice.equals("rock") || compChoice.equals("rock") && humanChoice.equals("scissors") || compChoice.equals("scissors") && humanChoice.equals("paper")){
            return(compChoice + " beats " + humanChoice + " -- " + name + "\033[0;31m LOSES\033[0;0m");
        } else {
            return("Match results in a tie");
        }
    }
}