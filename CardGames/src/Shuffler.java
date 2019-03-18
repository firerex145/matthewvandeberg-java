import java.util.Arrays;

public class Shuffler {
    public static void main(String[] args) {
        final int SHUFFLE_COUNT = 20;
        final int VALUE_COUNT = 52;
        int[] values = new int[VALUE_COUNT];
        for(int i = 1; i <= values.length; i++) {
            values[i - 1] = i;
        }
//        System.out.println("Original values:");
//        System.out.println(Arrays.toString(values) + "\n");
//        for (int i = 0; i < SHUFFLE_COUNT; i++) {
//            selectionShuffle(values);
//            System.out.println("After " + (i + 1) + " shuffles:");
//            System.out.println(Arrays.toString(values) + "\n");
//        }

        int[] otherValues = new int[VALUE_COUNT];
        for(int i = 1; i <= otherValues.length; i++) {
            otherValues[i - 1] = i;
        }
        int[] original = Arrays.copyOf(otherValues, otherValues.length);
        System.out.println("Original values:");
        System.out.println(Arrays.toString(otherValues) + "\n");
        for (int i = 0; i < SHUFFLE_COUNT; i++) {
            otherValues = Arrays.copyOf(perfectShuffle(otherValues), otherValues.length);
            System.out.println("After " + (i + 1) + " shuffles:");
            System.out.println(Arrays.toString(otherValues));
            System.out.println("Equal to original: " + Arrays.equals(otherValues, original) + "\n");
        }
    }
    public static void selectionShuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int random = (int)(Math.random() * i);
            int temp = arr[i];
            arr[i] = arr[random];
            arr[random] = temp;

        }
    }
    public static int[] perfectShuffle(int[] arr){
        int[] shuffled = new int[arr.length];
        int j = 0;
        for (int i = 0; i < (arr.length + 1) / 2; i++) {
            shuffled[j] = arr[i];
            j += 2;
        }
        j = 1;
        for (int i = (arr.length + 1) / 2; i < arr.length; i++) {
            shuffled[j] = arr[i];
            j += 2;
        }
        arr = Arrays.copyOf(shuffled, arr.length);
        return arr;
    }
}
