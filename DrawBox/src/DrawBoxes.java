public class DrawBoxes {
    public static void main(String[] args){

        int y = 6;

        System.out.println("Draw Boxes");
        for(int i = 0; i < y; i++) {

            drawBox(4);

        }
        System.out.println("Complete");
    }

    public static void drawBox(int x){

        for(int i = 0; i < x; i++){

            drawLine();

        }
        System.out.println();
        for(int a = 0; a < x; a++){
            drawMiddle();
        }
        System.out.println();
        for(int a = 0; a < x; a++){
            drawMiddle();
        }
        System.out.println();
        for(int i = 0; i < x; i++){

            drawLine();

        }
        System.out.println();
    }

    public static void drawLine(){
        System.out.print("+----+");
    }

    public static void drawMiddle(){
        System.out.print("|    |");
    }
}
