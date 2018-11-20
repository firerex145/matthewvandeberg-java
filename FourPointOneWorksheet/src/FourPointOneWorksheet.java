import java.util.Scanner;

public class FourPointOneWorksheet {
    public static void main (String[] args){
        //Exercise 1
        int[] list1 = new int[8];

        //Exercise 2a
        list1[0] = 1;
        list1[1] = 2;
        list1[2] = 3;
        list1[3] = 4;
        list1[4] = 5;
        list1[5] = 6;
        list1[6] = 7;
        list1[7] = 8;

        //Exercise 2b
        int[] list2b = {2, 5, 3, 7, 8};

        //Exercise 2c
        int[] list2c = {1, 2, 3, 4, 5};

        //Exercise 2d
        Scanner input = new Scanner(System.in);
        int[] list2d = new int[4];
        for (int i : list2d) {
            System.out.println("Input a number.");
            list2d[i] = input.nextInt();
            System.out.println();
        }

        //Exercise 2e
        int[] list2e = {-4, 19, 3, 20, 72, 58};

        //Exercise 3a
        System.out.println(list2d[list2d.length - 1]);

        //Exercise 3b
        System.out.println(list2d[list2d.length / 2 - 1]);

        //Exercise 3c
        for (int j : list2d){
            list2d[j]--;
        }

        //Exercise 3d
        int[] even = new int[500];
        for (int n : even){
            if ((n % 2) == 0){
                even[n / 2] = n;
            }
        }

        //Exercise 3f
        System.out.println(even[100]);

        //Exercise3g
    }
}
