import java.util.Arrays;
import java.util.Scanner;

public class FourPointSixWorksheet {
    public static void main(String[] args){
        //Exercise 1
        double[] array1 = new double[1028];

        //Exercise 2
        int[][] array2 = new int[5][4];

        //Exercise 3
        String[][] studentSeating = new String[6][4];

        //Exercise 5
        Scanner studentName = new Scanner(System.in);
        for(int i = 0; i < studentSeating.length; i++){
            for(int j = 2; j < studentSeating.length; j++){
                System.out.println("Enter a student's name");
                studentSeating[i][j - 2] = studentName.next();
            }
        }

        //Exercise 6
        System.out.println(studentSeating[2][studentSeating.length - 1]);

        //Exercise 7
        Scanner teacherName = new Scanner(System.in);
        System.out.println("Enter teacher's name");
        studentSeating[1][3] = teacherName.next();

        //Exercise 8
        String target = "";
        for(int i = 0; i < studentSeating.length; i++){
            for(int j = 2; j < studentSeating.length; j++){
                if(studentSeating[i][j - 2].equals("Matthew Vandeberg")){
                    studentSeating[i][j - 2] = target;
                }
                if(studentSeating[i][j - 2].equals(target)){
                    studentSeating[i][j - 2] = "Matthew Vandeberg";

                }
            }
        }

        //Exercise 9
        int[][] temperature = new int[10][2];

        //Exercise 10
        String[][] chessBoard = new String[8][8];
        Arrays.fill(chessBoard[1], "pawn");
        Arrays.fill(chessBoard[6], "pawn");

        //Exercise 11
        int[][] data = new int[4][7];
        for (int i = 0; i < data[2].length; i++){
            data[2][i] = i + 1;
        }

        //Exercise 12
        int temp1;
        int[][] matrix = new int[6][8];
        for(int i = 0; i < matrix[1].length; i++){
            temp1 = matrix[1][i];
            matrix[1][i] = matrix[4][i];
            matrix[4][i] = temp1;
        }

        //Exercise 14
        int[][] multiTable = new int[10][12]; //creates the multiplication table

        for (int i = 0; i < 1; i++){                          //
            for (int j = 0; j < multiTable[0].length; j++){   //
                multiTable[i][j] = j++;                       //fills the top row with numbers 1-12
            }                                                 //
        }                                                     //

        for (int i = 0; i < 10; i++){    //
            for (int j = 0; j < 1; j++){ //
                multiTable[i][j] = i++;  //fills the first column with numbers 1-10
            }                            //
        }                                //
        
        for (int i = 0; i < 10; i++){                                   //
            for (int j = 0; j < multiTable[0].length; j++){             //
                multiTable[i][j] = multiTable[i][0] * multiTable[0][j]; //does the multiplication and fills the rest of the table
            }                                                           //
        }                                                               //

        //Exercise 15
        int temp2;
        for(int i = 0; i < 10; i++){
            temp2 = multiTable[i][2];
            multiTable[i][2] = multiTable[i][6];
            multiTable[i][6] = temp2;
        }
    }
}
