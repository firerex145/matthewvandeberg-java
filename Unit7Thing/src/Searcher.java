import java.util.Arrays;

public class Searcher {
    public static void main(String[] args) {
        //int[] array = {0, 12, 50, 75, 112, 113, 114, 200, 500, 1000};
        //System.out.println(seqSearch(array, 12));
        //System.out.println(binarySearch(array, 1));

        int[] selArray = {22, 18, 12, -4, 27, 30, 36, 50, 7, 68, 91, 56, 2};

        System.out.println(Arrays.toString(selectionSort(selArray)));
    }

    public static int seqSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int actualMax = arr.length - 1;
        int max = arr.length - 1;
        int actualMin = 0;
        int min = 0;
        int mid = arr.length / 2;
        int go = 0;
        int i = 0;
        while(go == 0) {
            if (mid > actualMax || mid < actualMin){
                return -1;
            }
            i++;
            if (arr[mid] < target) {
                mid = (mid + max) / 2;
                max = arr.length - 1 - i;
            } else if (arr[mid] > target) {
                mid = (mid + min) / 2;
                min = i;
            } else {
                go = 1;
            }
        }
        return mid;
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
