package oy.tol.tra;

public class Algorithms {
    private Algorithms() {
        // Empty
    }

    public static int binarySearch(int target, Integer[] array, int fromIndex, int toIndex) {
        while (fromIndex <= toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                fromIndex = mid + 1;
            } else {
                toIndex = mid - 1;
            }
        }
        return -1;
    }


    public static int binarySearch(String value, String[] array, int fromIndex, int toIndex) {
        while (fromIndex <= toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            int cmp = array[mid].compareTo(value);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                fromIndex = mid + 1;
            } else {
                toIndex = mid - 1;
            }
        }
        return -1;
    }


    public static void sort(Integer[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    Integer temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }


    public static void sort(String[] array) {
        quickSort(array, 0, array.length - 1);
    }


    private static void quickSort(String[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(array, start, end);
            quickSort(array, start, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
    }


    private static int partition(String[] array, int start, int end) {
        String pivot = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        String temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;
        return i + 1;
    }
}