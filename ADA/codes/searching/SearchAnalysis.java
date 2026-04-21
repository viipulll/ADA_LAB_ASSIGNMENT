import java.util.*;

public class SearchAnalysis {

    // ----- Linear Search -----
    public static int linearSearch(int[] data, int target) {

        int index = 0;

        while (index < data.length) {
            if (data[index] == target) {
                return index;
            }
            index++;
        }

        return -1;
    }

    // ----- Binary Search -----
    public static int binarySearch(int[] data, int target) {

        int start = 0;
        int end = data.length - 1;

        while (start <= end) {

            int middle = start + (end - start) / 2;

            if (data[middle] == target) {
                return middle;
            } 
            else if (target > data[middle]) {
                start = middle + 1;
            } 
            else {
                end = middle - 1;
            }
        }

        return -1;
    }

    // ----- Create Sorted Array -----
    public static int[] generateSortedArray(int size) {

        Random r = new Random();
        int[] values = new int[size];

        for (int i = 0; i < size; i++) {
            values[i] = r.nextInt(size * 10);
        }

        Arrays.sort(values);
        return values;
    }

    // ----- Main Function -----
    public static void main(String[] args) {

        int[] testSizes = {10, 100, 500, 1000};
        int repeatCount = 1000;

        System.out.println("=== WORST CASE ===");
        System.out.println("n,Linear(ms),Binary(ms)");

        for (int size : testSizes) {

            int[] arr = generateSortedArray(size);
            int missingKey = -1;

            // Linear Worst
            long t1 = System.nanoTime();
            for (int k = 0; k < repeatCount; k++) {
                linearSearch(arr, missingKey);
            }
            double linWorst = (System.nanoTime() - t1) / 1_000_000.0;

            // Binary Worst
            long t2 = System.nanoTime();
            for (int k = 0; k < repeatCount; k++) {
                binarySearch(arr, missingKey);
            }
            double binWorst = (System.nanoTime() - t2) / 1_000_000.0;

            System.out.println(size + "," + linWorst + "," + binWorst);
        }

        // ----- Average Case -----
        System.out.println("\n=== AVERAGE CASE ===");
        System.out.println("n,Linear(ms),Binary(ms)");

        for (int size : testSizes) {

            int[] arr = generateSortedArray(size);
            int midKey = arr[size / 2];

            long t1 = System.nanoTime();
            for (int k = 0; k < repeatCount; k++) {
                linearSearch(arr, midKey);
            }
            double linAvg = (System.nanoTime() - t1) / 1_000_000.0;

            long t2 = System.nanoTime();
            for (int k = 0; k < repeatCount; k++) {
                binarySearch(arr, midKey);
            }
            double binAvg = (System.nanoTime() - t2) / 1_000_000.0;

            System.out.println(size + "," + linAvg + "," + binAvg);
        }

        // ----- Best Case -----
        System.out.println("\n=== BEST CASE ===");
        System.out.println("n,Linear(ms),Binary(ms)");

        for (int size : testSizes) {

            int[] arr = generateSortedArray(size);
            int firstElement = arr[0];

            long t1 = System.nanoTime();
            for (int k = 0; k < repeatCount; k++) {
                linearSearch(arr, firstElement);
            }
            double linBest = (System.nanoTime() - t1) / 1_000_000.0;

            long t2 = System.nanoTime();
            for (int k = 0; k < repeatCount; k++) {
                binarySearch(arr, firstElement);
            }
            double binBest = (System.nanoTime() - t2) / 1_000_000.0;

            System.out.println(size + "," + linBest + "," + binBest);
        }
    }
}