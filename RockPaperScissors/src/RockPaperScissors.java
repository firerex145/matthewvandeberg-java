import java.util.Scanner;

public class RockPaperScissors {
    static Scanner player = new Scanner(System.in);
    static String name;
    public static void main(String[] args){
        int humanWins = 0;
        int compWins = 0;
        int ties = 0;
        int humanGames = 0;
        int compGames = 0;
        int playAgain = 0;
        int games = 1;
        System.out.println("What is your name?");
        name = player.next();
        while(playAgain == 0) {
            System.out.println("Would you like to play three or five rounds?");
            int rounds = player.nextInt();
            while (!(rounds == 3 || rounds == 5)) {
                System.out.println("You can only play three or five rounds. Renter how many rounds you want to play.");
                rounds = player.nextInt();
            }
            while((rounds + ties) > 0){
                System.out.println("Enter 0 (rock), 1 (paper), or 2 (scissors).");
                int input = player.nextInt();
                System.out.println("Rock, Paper, Scissors; Shoot!");
                int compInput = (int)(3 * Math.random());
                String roundResults = play(input, compInput);
            }
        }
    }
    public static String play(int playerInput, int compInput){
        String human;
        String computer;
        while(playerInput > 2 || playerInput < 0){
            System.out.println("You have to choose a number between 0-2 for your input. Please renter selection");
            playerInput = player.nextInt();
        }
        if (playerInput == 0){
            human = "rock";
        } else if (playerInput == 1){
            human = "paper";
        } else {
            human = "scissors";
        }
        if (playerInput == 0){
            computer = "rock";
        } else if (playerInput == 1){
            computer = "paper";
        } else {
            computer = "scissors";
        }
        return(results(human, computer));
    }
    public static String results(String humanChoice, String compChoice){
        System.out.printf(name + " chooses: %10s\n", humanChoice);
        System.out.printf("Computer chooses: %10s\n", compChoice);
        if (humanChoice.equals("paper") && compChoice.equals("rock") || humanChoice.equals("rock") && compChoice.equals("scissors") || humanChoice.equals("scissors") && compChoice.equals("paper")){
            return(humanChoice + " beats " + compChoice + " - " + name + " wins");
        } else if(){

        } else {

        }
    }
}
