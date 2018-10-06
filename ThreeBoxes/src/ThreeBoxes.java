/*
Matthew Vandeberg
AP CS A
Period 1
10-5-18
Project #5 - ThreeBoxes
 */
public class ThreeBoxes {

    public static final int ROWS = 3; //class constant for number of rows in each box
    public static final int COLUMNS = 6; //class constant for number of columns in each box

    public static void main (String[] args){
        star();
        System.out.println();
        dollars();
        System.out.println();
        pounds();
    }

    public static void star() { //prints box of stars
        for (int i = 0; i < ROWS; i++){ //determines amount of rows in box of stars
            for (int j = 0; j < COLUMNS; j++){ //determines amount of columns in box of stars
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void dollars() { //prints box of dollar signs
        for (int i = 0; i < ROWS; i++){ //determines amount of rows in box of dollar signs
            for (int j = 0; j < COLUMNS; j++){ //determines amount of columns in box of dollar signs
                System.out.print("$ ");
            }
            System.out.println();
        }
    }
    public static void pounds() { //prints box of pound symbols
        for (int i = 0; i < ROWS; i++){ //determines amount of rows in box of pound symbols
            for (int j = 0; j < COLUMNS; j++){ //determines amount of columns in box of pound symbols
                System.out.print("# ");
            }
            System.out.println();
        }
    }
}