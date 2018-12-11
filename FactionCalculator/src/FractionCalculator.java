import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int loop = 0;
        while (loop == 0){
            System.out.print("Enter something: ");

            for (int i = 0; i < 3; i++){
                if (input.nextLine().contains("quit")){
                    System.out.println("Program ended");
                    loop++;
                    break;
                } else {
                    System.out.println(input.next());
                }
            }
            System.out.println("");
        }
    }
}
