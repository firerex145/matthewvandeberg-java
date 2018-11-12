import java.util.Random;
import java.util.Scanner;
/*
Matthew Vandeberg
AP CS A
Period 1
9-27-18
Project #6 - Draw Rocket
*/
public class RockPaperScissors {

    static Scanner player = new Scanner(System.in); //initializes scanner object named "player"
    static String name; //creates a string called "name"

    public static void main(String[] args){

        int humanGames = 0; //initializes an integer named "humanGames" (to track number of games the user has won) and gives it a value of 0.
        int compGames = 0; //initializes an integer named "compGames" (to track number of games the computer has won) and gives it a value of 0.
        int playAgain = 0; //initializes an integer named "playAgain" (which allows user to play multiple times) and gives it a value of 0.
        int games = 1; //initializes an integer named "games" (to track total number of games) and gives it a value of 1 for the first game.

        Random rand = new Random(); //initializes random object named "rand"

        String rematch; //creates a string called "rematch"

        System.out.println("What is your name?"); //prompts the user to input their name
        name = player.next(); //reads the input(the user's name) from the console and assigns it to the string "name"

        while(playAgain == 0) { //keeps the program in a loop until the user doesn't want to play anymore

            int humanWins = 0; //initializes an integer named "humanWins" (to track number of rounds the user won in a game) and gives it a value of 0.
            int compWins = 0;  //initializes an integer named "compWins" (to track number of rounds the computer won in a game) and gives it a value of 0.
            int ties = 0;      //initializes an integer named "ties" (to track number of rounds that were ties in a game) and gives it a value of 0.
            int rematchPrompt = 0; //initializes an integer named "rematchPrompt" (used when asking user if they want to play again) and gives it a value of 0.

            System.out.println("Would you like to play three or five rounds?"); //prompts the user to input how many rounds to play
            int rounds = player.nextInt(); //initializes an integer named "rounds" which stores the number of rounds to play specified by the user

            while (!(rounds == 3 || rounds == 5)) { //runs while the number of rounds does not equal 3 or 5 to make sure user only plays 3 or 5 rounds
                System.out.println("You can only play three or five rounds. Re-enter how many rounds you want to play."); //tells user to only input 3 or 5 for number of rounds
                rounds = player.nextInt(); //reads input and assigns value to "rounds"
            }

            while(rounds > 0 - ties){ //runs for the number of rounds specified earlier

                System.out.println("Enter 0 (rock), 1 (paper), or 2 (scissors)."); //asks user to choose rock, paper, or scissors.
                int input = player.nextInt(); //reads input and stores it as an integer in variable "input"

                int compInput = rand.nextInt(3); //computer randomly chooses number between 0 & 2 for its choice

                String roundResults = play(input, compInput); //passes user's and computer's choice to the "play" method and stores the returned string in "roundResults"
                System.out.println(roundResults + "\n"); //prints the results of the most recent round

                if (roundResults.endsWith("WINS\033[0;0m") == true) { //code runs if the user wins
                    humanWins++; //adds one to number of rounds won by user

                } else if (roundResults.endsWith("LOSES\033[0;0m") == true) { //code runs if human loses
                    compWins++; //adds one to number of rounds won by computer

                } else { //code runs if round ends in tie
                    ties++; //adds one to number of rounds that ended in a tie
                }

                System.out.print("Match Standings: ");
                System.out.printf(name + " wins -- %2s  Computer wins -- %2s  Ties -- %2s\n\n", humanWins, compWins, ties); //prints out current match standings

                rounds--; //subtracts one from total number of rounds because a round has finished
            }

            if (humanWins > compWins) { //code runs if user wins the game
                System.out.println("game " + games + " results: " + name + " beats computer " + humanWins + " to " + compWins); //prints results of most recent game
                humanGames++; //adds one to number of games user has won

            } else { //code runs if computer wins the game
                System.out.println("game " + games + " results: computer beats " + name + " " + compWins + " to " + humanWins); //prints results of most recent game
                compGames++; //adds one to number of games computer has won
            }

            System.out.printf("Overall standings: " + name + " -- %2s wins Computer -- %2s wins\n", humanGames, compGames); //prints amount of games the user and the computer have played

            System.out.println("Rematch? (yes/no)"); //asks the user if they want a rematch
            rematch = player.next(); //stores answer in "rematch"

            while (rematchPrompt == 0) { //runs to see if user gave an appropriate answer

                if (rematch.equalsIgnoreCase("yes") || rematch.equalsIgnoreCase("y")) { //runs if user said yes to a rematch
                    games++; //adds one to total number of games
                    rematchPrompt++; //ends the above while loop

                } else if (rematch.equalsIgnoreCase("no") || rematch.equalsIgnoreCase("n")) { //runs if user said no to a rematch
                    playAgain = 1; //ends the program
                    rematchPrompt++; //ends the above while loop

                } else { //runs if user gave an inappropriate answer
                    System.out.println("Please answer with yes or no"); //tells user to answer with yes or no
                    rematch = player.next(); //stores answer in "rematch"
                }
            }
        }
    }

    public static String play(int playerInput, int compInput){ //method that converts the integers chosen by the user and computer into the string rock, paper, or scissors

        String human; //creates a string called "human" to store the user's choice as a string
        String computer; //creates a string called "computer" to store the computer's choice as a string

        while(playerInput > 2 || playerInput < 0){ //loop that makes sure user chooses an appropriate choice (0, 1, or 2)
            System.out.println("You have to choose a number between 0-2 for your input. Please re-enter selection"); //tells user they can only choose a number between 0 & 2
            playerInput = player.nextInt(); //stores correct input and exits while loop
        }

        if (playerInput == 0){ //runs if user chose "rock"
            human = "rock"; //converts user's choice from integer to string

        } else if (playerInput == 1){ //runs if user chose "paper"
            human = "paper"; //converts user's choice from integer to string

        } else { //runs if user chose "scissors"
            human = "scissors"; //converts user's choice from integer to string
        }

        if (compInput == 0){ //runs if computer chose "rock"
            computer = "rock"; //converts computer's choice from integer to string

        } else if (compInput == 1){ //runs if computer chose "paper"
            computer = "paper"; //converts computer's choice from integer to string

        } else { //runs if computer chose "scissors"
            computer = "scissors"; //converts computer's choice from integer to string
        }

        return(results(human, computer)); //passes the string version of user's and computer's inputs to the "results" method and returns the value returned by "results" to the "main" method
    }

    public static String results(String humanChoice, String compChoice){ //takes the string version of the user's and computer's inputs and returns the results of the match

        System.out.println("Rock, Paper, Scissors; Shoot!\n"); //signals start of a round

        System.out.printf(name + " chooses: %10s\n", humanChoice); //prints out the user's choice
        System.out.printf("Computer chooses: %10s\n", compChoice); //prints out the computer's choice

        if (humanChoice.equals("paper") && compChoice.equals("rock") || humanChoice.equals("rock") && compChoice.equals("scissors") || humanChoice.equals("scissors") && compChoice.equals("paper")){ //runs if user wins round
            return(humanChoice + " beats " + compChoice + " -- " + name + "\033[0;32m WINS\033[0;0m"); //returns how user beat computer and that the user won (word "WINS" will be green)

        } else if(compChoice.equals("paper") && humanChoice.equals("rock") || compChoice.equals("rock") && humanChoice.equals("scissors") || compChoice.equals("scissors") && humanChoice.equals("paper")){ //runs if computer wins round
            return(compChoice + " beats " + humanChoice + " -- " + name + "\033[0;31m LOSES\033[0;0m"); //returns how computer beat the user and that the user lost (word "LOSES" will be red)

        } else { //runs if round ends in a tie
            return("Round results in a tie");
        }
    }
}