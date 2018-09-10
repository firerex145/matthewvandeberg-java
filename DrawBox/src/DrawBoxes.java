public class DrawBoxes {
    public static void main(String[] args){
        int y = 3;
        int x = 3;

        System.out.println("Draw Boxes");
        for(int i = 0; i < x; i++){

            drawBox();

        }
        System.out.println("Complete");
    }

    public static void drawBox(){
        System.out.println();
        drawLine();
        drawMiddle();
        drawMiddle();
        drawLine();
    }

    public static void drawLine(){
        System.out.println("+----+");
    }

    public static void drawMiddle(){
        System.out.println("|    |");
    }
}
