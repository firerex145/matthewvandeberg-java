public class ThreeBoxes {

    public static void main (String[] args){
        printBox(5, 3, '*');
        printBox(7, 8, '$');
        printBox(2, 2, '#');
    }

    public static void printBox(int height, int width, char print) {
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                System.out.print(print);
            }
            System.out.println();
        }
        System.out.println();
    }
}