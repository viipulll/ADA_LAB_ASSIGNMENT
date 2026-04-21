import java.util.Random;

public class Quicksort {

    static long comparisons = 0;

    // ----- Partition Logic -----
    public static int partition(int[] data, int start, int end) {

        int pivotValue = data[end];
        int pointer = start - 1;

        for (int idx = start; idx < end; idx++) {

            comparisons++;

            if (data[idx] <= pivotValue) {
                pointer++;

                int tempVal = data[pointer];
                data[pointer] = data[idx];
                data[idx] = tempVal;
            }
        }

        int swapTemp = data[pointer + 1];
        data[pointer + 1] = data[end];
        data[end] = swapTemp;

        return pointer + 1;
    }

    // ----- QuickSort Function -----
    public static void Quicksort(int[] data, int start, int end) {

        if (start < end) {

            int pivotIndex = partition(data, start, end);

            Quicksort(data, start, pivotIndex - 1);
            Quicksort(data, pivotIndex + 1, end);
        }
    }

    // ----- Random Data -----
    public static int[] generateRandomArray(int size) {

        Random r = new Random();
        int[] values = new int[size];

        for (int i = 0; i < size; i++) {
            values[i] = r.nextInt(1000);
        }

        return values;
    }

    // ----- Sorted Data -----
    public static int[] generateSortedArray(int size) {

        int[] values = new int[size];

        int i = 0;
        while (i < size) {
            values[i] = i;
            i++;
        }

        return values;
    }

    // ----- Main -----
    public static void main(String[] args) {

        int[] testSizes = {10, 20, 30, 40};

        for (int n : testSizes) {

            System.out.println("Size = " + n);

            // Average Case
            int[] randomData = generateRandomArray(n);
            comparisons = 0;
            Quicksort(randomData, 0, n - 1);
            System.out.println("Avg Comparisons: " + comparisons);

            // Worst Case
            int[] sortedData = generateSortedArray(n);
            comparisons = 0;
            Quicksort(sortedData, 0, n - 1);
            System.out.println("Worst Comparisons: " + comparisons);

            System.out.println("--------------------------");
        }
    }
}