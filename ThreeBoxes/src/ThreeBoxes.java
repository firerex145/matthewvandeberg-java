public class ThreeBoxes {

    public static final int ROWS = 3;
    public static final int COLUMNS = 6;

    public static void main (String[] args){
        star();
        System.out.println();
        dollars();
        System.out.println();
        pounds();
    }

    public static void star() {
        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLUMNS; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void dollars() {
        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLUMNS; j++){
                System.out.print("$ ");
            }
            System.out.println();
        }
    }
    public static void pounds() {
        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLUMNS; j++){
                System.out.print("# ");
            }
            System.out.println();
        }
    }
}