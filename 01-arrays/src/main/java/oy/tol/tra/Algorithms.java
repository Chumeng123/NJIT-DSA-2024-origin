package oy.tol.tra;

public class Algorithms {
    public static <E extends Comparable<E>> void sort(E [] array) {


        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    E temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // ...
    public static <T> void reverse(T [] array) {

        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            T temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }

    }
}
