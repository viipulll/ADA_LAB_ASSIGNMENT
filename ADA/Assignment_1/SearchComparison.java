import java.util.*;

public class SearchComparison {

    // ----- Linear Search -----
    public static int performLinearSearch(int[] arr, int target) {

        int pos = 0;

        while (pos < arr.length) {
            if (arr[pos] == target) {
                return pos;
            }
            pos++;
        }

        return -1;
    }

    // ----- Binary Search -----
    public static int performBinarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } 
            else if (target > arr[mid]) {
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }

        return -1;
    }

    // ----- Create Sorted Data -----
    public static int[] generateSortedData(int n) {

        Random random = new Random();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt(n * 10);
        }

        Arrays.sort(data);
        return data;
    }

    // ----- Time Calculation -----
    public static double measureTime(Runnable job, int times) {

        long begin = System.nanoTime();

        for (int i = 0; i < times; i++) {
            job.run();
        }

        long finish = System.nanoTime();

        return (finish - begin) / 1_000_000.0;
    }

    // ----- Main -----
    public static void main(String[] args) {

        int[] inputSizes = {10, 100, 500, 1000};
        int repeatCount = 1000;

        // ----- Worst Case -----
        System.out.println("=== WORST CASE ===");
        System.out.println("n,Linear(ms),Binary(ms)");

        for (int size : inputSizes) {

            int[] arr = generateSortedData(size);
            int missing = -1;

            double linWorst = measureTime(
                    () -> performLinearSearch(arr, missing), repeatCount);

            double binWorst = measureTime(
                    () -> performBinarySearch(arr, missing), repeatCount);

            System.out.println(size + "," + linWorst + "," + binWorst);
        }

        // ----- Average Case -----
        System.out.println("\n=== AVERAGE CASE ===");
        System.out.println("n,Linear(ms),Binary(ms)");

        for (int size : inputSizes) {

            int[] arr = generateSortedData(size);
            int middleValue = arr[size / 2];

            double linAvg = measureTime(
                    () -> performLinearSearch(arr, middleValue), repeatCount);

            double binAvg = measureTime(
                    () -> performBinarySearch(arr, middleValue), repeatCount);

            System.out.println(size + "," + linAvg + "," + binAvg);
        }

        // ----- Best Case -----
        System.out.println("\n=== BEST CASE ===");
        System.out.println("n,Linear(ms),Binary(ms)");

        for (int size : inputSizes) {

            int[] arr = generateSortedData(size);
            int firstVal = arr[0];

            double linBest = measureTime(
                    () -> performLinearSearch(arr, firstVal), repeatCount);

            double binBest = measureTime(
                    () -> performBinarySearch(arr, firstVal), repeatCount);

            System.out.println(size + "," + linBest + "," + binBest);
        }
    }
}