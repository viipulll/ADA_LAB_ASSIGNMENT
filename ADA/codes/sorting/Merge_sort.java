public class Merge_sort {

    public static void main(String[] args) {

        int[] data = new int[15];

        // fill array with random values
        for (int idx = 0; idx < data.length; idx++) {
            data[idx] = (int)(Math.random() * 100) + 1;
        }

        System.out.println("Original Array:");
        for (int val : data) {
            System.out.print(val + " ");
        }

        int totalSteps = mergeSort(data);

        System.out.println("\nSteps counted: " + totalSteps);

        System.out.println("After Sorting:");
        for (int val : data) {
            System.out.print(val + " ");
        }
    }

    // ----- Merge Sort -----
    public static int mergeSort(int[] data) {

        int stepCounter = 0;

        if (data.length <= 1) {
            return stepCounter;
        }

        int middle = data.length / 2;

        int[] part1 = new int[middle];
        int[] part2 = new int[data.length - middle];

        // copy left part
        int x = 0;
        while (x < middle) {
            part1[x] = data[x];
            x++;
            stepCounter++;
        }

        // copy right part
        int y = middle;
        int z = 0;
        while (y < data.length) {
            part2[z] = data[y];
            y++;
            z++;
            stepCounter++;
        }

        stepCounter += mergeSort(part1);
        stepCounter += mergeSort(part2);

        stepCounter += merge(data, part1, part2);

        return stepCounter;
    }

    // ----- Merge Function -----
    public static int merge(int[] data, int[] part1, int[] part2) {

        int steps = 0;

        int i = 0, j = 0, k = 0;

        while (i < part1.length && j < part2.length) {

            if (part1[i] < part2[j]) {
                data[k] = part1[i];
                i++;
            } else {
                data[k] = part2[j];
                j++;
            }

            k++;
            steps++;
        }

        // remaining elements of part1
        while (i < part1.length) {
            data[k++] = part1[i++];
            steps++;
        }

        // remaining elements of part2
        while (j < part2.length) {
            data[k++] = part2[j++];
            steps++;
        }

        return steps;
    }
}