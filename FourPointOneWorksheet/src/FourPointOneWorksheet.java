/*
Matthew Vandeberg
11-27-18
AP CS A
4.1 Worksheet
*/

import java.util.Arrays;
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
        for (int n = 0; n < even.length * 2; n++){
            if ((n % 2) == 0){
                even[n / 2] = n;
            }
        }


        //Exercise 3f
        System.out.println(even[100]);

        //Exercise 3g
        System.out.println(even[278] + " " + even[456]);

        //Exercise 3h
        int[] odds = new int[Math.abs(-4 - 5) / 2 + 2];
        odds[0] = -4;
        for(int m = 2; m <= odds.length; m++){
            odds[m - 1] = (m - 3) * 2 - 1;
        }
        System.out.println(Arrays.toString(odds));

        //Exercise 3i
        int num1 = 0;
        int num2 = 1;
        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);
        int[] modOdds = new int[Math.abs(max - min) / 2];
        if (min == -1 && max == 1){
            modOdds = Arrays.copyOf(modOdds, modOdds.length + 1);
        }
        if(min % 2 == 0 || max % 2 == 0){
            modOdds = Arrays.copyOf(modOdds, modOdds.length + 2);
            if(min % 2 == 0 && max % 2 == 0){
                modOdds[0] = min;
                int j = 1;
                for(int i = min + 1; i <= max; i += 2){
                    modOdds[j] = i;
                    j++;
                }
                modOdds[modOdds.length - 1] = max;
            } else {
                if(min % 2 == 0){
                    modOdds[0] = min;
                    int j = 1;
                    for(int i = min + 1; i <= max; i += 2){
                        modOdds[j] = i;
                        j++;
                    }
                } else {
                    int j = 0;
                    for(int i = min; i <= max; i += 2){
                        modOdds[j] = i;
                        j++;
                    }
                    modOdds[modOdds.length - 1] = max;
                }
            }
        } else {
            int j = 0;
            for(int i = min; i < max; i += 2){
                modOdds[j] = i;
                j++;
            }
            modOdds[modOdds.length - 1] = max;
        }
        System.out.println(Arrays.toString(modOdds));
    }
}
