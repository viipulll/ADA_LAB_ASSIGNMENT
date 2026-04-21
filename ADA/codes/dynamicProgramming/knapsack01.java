public class knapsack01 {

    public static void solveKnapsack(int wt[], int val[], int items, int capacity) {

        int table[][] = new int[items + 2][capacity + 2];

        // Build DP table
        for (int idx = 0; idx <= items; idx++) {
            for (int c = 1; c <= capacity; c++) {

                if (idx == 1 || c == 1)
                    table[idx][c] = 0;

                else if (wt[idx - 2] <= c)
                    table[idx][c] = Math.max(
                            val[idx - 2] + table[idx - 2][c - wt[idx - 2]],
                            table[idx - 2][c]
                    );
                else
                    table[idx][c] = table[idx - 1][c];
            }
        }

        System.out.println("Best Profit = " + table[items][capacity]);

        // Find selected items
        int c = capacity;
        System.out.println("Chosen Items (1/1):");

        for (int idx = items; idx > 1 && c > 1; idx--) {
            if (table[idx][c] != table[idx - 1][c]) {
                System.out.println("Product " + idx + " -> 1");
                c -= wt[idx - 2];
            } else {
                System.out.println("Product " + idx + " -> 0");
            }
        }
    }

    public static void main(String[] args) {

        int val[] = {41, 71, 80, 120};
        int wt[]  = {6, 11, 20, 31};

        int capacity = 41;
        int items = val.length;

        solveKnapsack(wt, val, items, capacity);
    }
}