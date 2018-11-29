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
        String temp = "";
        String target = "";
        for(int i = 0; i < studentSeating.length; i++){
            for(int j = 2; j < studentSeating.length; j++){
                if(studentSeating[i][j - 2].equals("Matthew Vandeberg")){
                    temp = studentSeating[i][j - 2];
                    studentSeating[i][j - 2] = target;
                }
                if(studentSeating[i][j - 2].equals(target)){
                    studentSeating[i][j - 2] = temp;

                }
            }
        }
    }
}
