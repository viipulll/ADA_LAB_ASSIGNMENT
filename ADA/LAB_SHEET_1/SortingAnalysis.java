import java.util.Random;

public class SortingAnalysis {

    // ----- Swap Utility -----
    private static void swap(int[] array, int a, int b) {
        int tempValue = array[a];
        array[a] = array[b];
        array[b] = tempValue;
    }

    // ----- Bubble Sort -----
    public static long performBubbleSort(int[] array) {
        long count = 0;
        int length = array.length;

        for (int round = 0; round < length - 1; round++) {

            boolean flag = false;

            for (int idx = 0; idx < length - round - 1; idx++) {
                count++;

                if (array[idx] > array[idx + 1]) {
                    swap(array, idx, idx + 1);
                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
        }
        return count;
    }

    // ----- Selection Sort -----
    public static long performSelectionSort(int[] array) {
        long count = 0;
        int size = array.length;

        for (int i = 0; i < size - 1; i++) {

            int minPos = i;

            for (int j = i + 1; j < size; j++) {
                count++;

                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }

            if (minPos != i) {
                swap(array, i, minPos);
            }
        }
        return count;
    }

    // ----- Insertion Sort -----
    public static long performInsertionSort(int[] array) {
        long count = 0;

        for (int i = 1; i < array.length; i++) {

            int key = array[i];
            int pos = i - 1;

            while (pos >= 0) {
                count++;

                if (array[pos] > key) {
                    array[pos + 1] = array[pos];
                    pos--;
                } else {
                    break;
                }
            }

            array[pos + 1] = key;
        }

        return count;
    }

    // ----- Random Data -----
    public static int[] createRandomData(int size) {
        Random r = new Random();
        int[] data = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = r.nextInt(1000);
        }

        return data;
    }

    // ----- Sorted Data -----
    public static int[] createSortedData(int size) {
        int[] data = new int[size];

        int i = 0;
        while (i < size) {
            data[i] = i;
            i++;
        }

        return data;
    }

    // ----- Reverse Data -----
    public static int[] createReverseData(int size) {
        int[] data = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = size - i;
        }

        return data;
    }

    // ----- Print Results -----
    public static void displayResults(String label, int n, int[] original) {

        System.out.println("\n" + label + " -> size = " + n);

        int[] copy1 = original.clone();
        int[] copy2 = original.clone();
        int[] copy3 = original.clone();

        System.out.println("Bubble Comparisons   : " + performBubbleSort(copy1));
        System.out.println("Selection Comparisons: " + performSelectionSort(copy2));
        System.out.println("Insertion Comparisons: " + performInsertionSort(copy3));
    }

    // ----- Main -----
    public static void main(String[] args) {

        int[] sizes = {10, 20, 30, 40};

        for (int currentSize : sizes) {

            System.out.println("\n--------------------------------------");
            System.out.println(" Processing Input Size: " + currentSize);
            System.out.println("--------------------------------------");

            displayResults("BEST CASE",
                    currentSize, createSortedData(currentSize));

            displayResults("WORST CASE",
                    currentSize, createReverseData(currentSize));

            displayResults("AVERAGE CASE",
                    currentSize, createRandomData(currentSize));
        }
    }
}