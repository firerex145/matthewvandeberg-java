/*
Matthew Vandeberg
AP CS A
Period 1
9-27-18
Project #6 - Draw Rocket
 */
public class DrawRocketSchoolCopy {

    public static final int SIZE = 3;  //determines how big the rocket is

    public static void main(String[] args){
        drawCone();
        drawDivider();
        drawUp();
        drawDown();
        drawDivider();
        drawDown();
        drawUp();
        drawDivider();
        drawCone();
    }
    public static void drawCone(){  //draws the cone on the bottom and top of rocket
        for (int rows = 1; rows < (SIZE * 2); rows++){  //loop for the amount of rows in he cones
            for(int spaces = SIZE * 2; spaces > rows; spaces--){  //prints the indents for the cone
                System.out.print(" ");
            }
            for(int forslash = 0; forslash < rows; forslash++){  //prints the forward slashes
                System.out.print("/");
            }
            System.out.print("**");  //prints the *s in the middle of cone
            for(int backslash = 0; backslash < rows; backslash++){  //prints the backslashes
                System.out.print("\\");
            }
            System.out.println();
        }
    }
    public static void drawDivider() {  //prints the dividers of the rocket
        System.out.print("+");
        for (int i = 0; i < (SIZE * 2); i++) { //prints the =* between the +s.
            System.out.print("=*");
        }
        System.out.println("+");
    }
    public static void drawUp(){  //draws the parts of the body that points up (/\)
        for (int rows = 1; rows < (SIZE + 1); rows++) { //determines the amount of rows in the body
            System.out.print("|");  //prints the left border of the body
            for (int i = 0; i < (SIZE - rows); i++) {  //prints the first group of periods in the body
                System.out.print(".");
            }
            for (int j = 0; j < rows; j++) {  //prints the first forward and backlash
                System.out.print("/\\");
            }
            for (int l = 0; l < (SIZE - rows); l++) {  //prints the periods between the first and second groups of slashes
                System.out.print("..");
            }
            for (int m = 0; m < rows; m++) {  //prints the second group of slashes
                System.out.print("/\\");
            }
            for (int n = 0; n < (SIZE - rows); n++) {  //prints the last group of periods
                System.out.print(".");
            }
            System.out.println("|");  //prints the closing border of the body
        }
    }
    public static void drawDown(){  //does the inverse of drawUp
        for (int rows = 1; rows < (SIZE + 1); rows++) {  //determines the amount of rows in the body
            System.out.print("|");  //prints the left border of the body
            for (int i = SIZE - 1; i > (SIZE - rows); i--) {  //prints the first group of periods
                System.out.print(".");
            }
            for (int j = SIZE + 1; j > rows; j--) {  //prints the first group of slashes that point down (\/)
                System.out.print("\\/");
            }
            for (int l = SIZE - 1; l > (SIZE - rows); l--) {  //prints the group of periods between the two groups of slashes
                System.out.print("..");
            }
            for (int m = SIZE + 1; m > rows; m--) {  //prints the second group of slashes
                System.out.print("\\/");
            }
            for (int n = SIZE - 1; n > (SIZE - rows); n--) { //prints the final group of periods
                System.out.print(".");
            }
            System.out.println("|");  //prints the right border of the body
        }
    }
}