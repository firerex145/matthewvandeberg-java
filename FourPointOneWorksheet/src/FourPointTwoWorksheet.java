/*
Matthew Vandeberg
11-27-18
AP CS A
4.2 Worksheet
*/

import java.util.Arrays;

public class FourPointTwoWorksheet {
    public static void main(String[] args){
        int[] array1 = {10, -2, 4, -4, 9, -5, 19, -7, 39, -1};
        int[] numbers = {11, 4, 99, 2, 44, 0, 0, 0};

        //Exercise 1d
        max(array1);

        //Exercise 1e
        average(array1);

        //Exercise 2a
        Arrays.copyOf(numbers, numbers.length * 2);

        //Exercise 2b
        Arrays.copyOfRange(numbers, 0, 3);

        //Exercise 2c
        Arrays.fill(numbers, 42);

        //Exercise 3
        range(array1);

        //Exercise 4
        mode(array1);
    }

    //Exercise 1d
    public static int max(int[] maxArray){
        int maxInt = 0;
        for (int i : maxArray){
            if (i > maxInt){
                maxInt = i;
            }
        }
        return maxInt;
    }

    //Exercise 1e
    public static double average(int[] averageArray){
        double sum = 0.0;
        for (int i : averageArray){
            sum += i;
        }
        double averageVal = sum / averageArray.length;
        return averageVal;
    }

    //Exercise 3
    public static int range(int[] rangeArray){
        int max = 0;
        for(int j : rangeArray){
            if(j > max){
                max = j;
            }
        }
        int min = max;
        for(int i : rangeArray){
            if(i < min){
                min = i;
            }
        }
        int rangeVal = max - min + 1;
        return rangeVal;
    }

    //Exercise 4
    public static int mode(int[] modeArray){
        Arrays.sort(modeArray);
        int[] singleElement = {modeArray[modeArray.length - 1], 0};
        int modeVal;
        int element;
        int count;
        for(int i : modeArray) {
            count = 0;
            element = i;
            for (int j : modeArray) {
                if(element == j){
                    count++;
                }
            }
            if(count >= singleElement[1]){
                if(count == singleElement[1]){
                    if(element < singleElement[0]){
                        singleElement[0] = element;
                    }
                }else {
                    singleElement[0] = element;
                }
                singleElement[1] = count;
            }
        }
        modeVal = singleElement[0];
        return modeVal;
    }
}