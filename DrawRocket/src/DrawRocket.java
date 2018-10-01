/*
Matthew Vandeberg
AP CS A
Period 1
9-27-18
Project #6 - Draw Rocket
 */
public class DrawRocket {

    public static final int SIZE = 3;

    public static void main(String[] args){
        drawCone();
        drawDivider();
        drawUp();
        drawDown();
    }
    public static void drawCone(){
        for (int i = 1; i < (SIZE * 2); i++){
            for(int j = 0; j < i; j++){
                System.out.print("/");
            }
            System.out.print("**");
            for(int g = 0; g < i; g++){
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
}
