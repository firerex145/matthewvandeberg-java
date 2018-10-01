/*
Matthew Vandeberg
AP CS A
Period 1
9-27-18
Project #6 - Draw Rocket
 */
public class DrawRocketSchoolCopy {

    public static final int SIZE = 7;

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
    public static void drawCone(){
        for (int rows = 1; rows < (SIZE * 2); rows++){
            for(int spaces = SIZE * 2; spaces > rows; spaces--){
                System.out.print(" ");
            }
            for(int forslash = 0; forslash < rows; forslash++){
                System.out.print("/");
            }
            System.out.print("**");
            for(int backslash = 0; backslash < rows; backslash++){
                System.out.print("\\");
            }
            System.out.println();
        }
    }
    public static void drawDivider() {
        System.out.print("+");
        for (int i = 0; i < (SIZE * 2); i++) {
            System.out.print("=*");
        }
        System.out.println("+");
    }
    public static void drawUp(){
        for (int k = 1; k < (SIZE + 1); k++) {
            System.out.print("|");
            for (int i = 0; i < (SIZE - k); i++) {
                System.out.print(".");
            }
            for (int j = 0; j < k; j++) {
                System.out.print("/\\");
            }
            for (int l = 0; l < (SIZE - k); l++) {
                System.out.print("..");
            }
            for (int m = 0; m < k; m++) {
                System.out.print("/\\");
            }
            for (int n = 0; n < (SIZE - k); n++) {
                System.out.print(".");
            }
            System.out.println("|");
        }
    }
    public static void drawDown(){
        for (int k = 1; k < (SIZE + 1); k++) {
            System.out.print("|");
            for (int i = SIZE - 1; i > (SIZE - k); i--) {
                System.out.print(".");
            }
            for (int j = SIZE + 1; j > k; j--) {
                System.out.print("\\/");
            }
            for (int l = SIZE - 1; l > (SIZE - k); l--) {
                System.out.print("..");
            }
            for (int m = SIZE + 1; m > k; m--) {
                System.out.print("\\/");
            }
            for (int n = SIZE - 1; n > (SIZE - k); n--) {
                System.out.print(".");
            }
            System.out.println("|");
        }
    }
}