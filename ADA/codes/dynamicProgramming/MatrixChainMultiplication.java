public class MatrixChainMultiplication {

    static char name = 'A';

    public static void matrixChainOrder(int p[], int n) {

        int[][] m = new int[n][n];
        int[][] bracket = new int[n][n];

        // cost is zero when multiplying one matrix
        for (int i = 1; i < n; i++)
            m[i][i] = 0;

        // chain length
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j]
                            + p[i - 1] * p[k] * p[j];

                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        bracket[i][j] = k;
                    }
                }
            }
        }

        // 🔥 PRINT MATRIX NAMES + DIMENSIONS
        System.out.println("Matrices:");
        for (int i = 1; i < n; i++) {
            char matrixName = (char) ('A' + i - 1);
            System.out.println(matrixName + " = " + p[i - 1] + " x " + p[i]);
        }

        System.out.println("\nMinimum Multiplications = " + m[1][n - 1]);

        System.out.print("Optimal Parenthesization: ");
        name = 'A'; // reset
        printParenthesis(1, n - 1, bracket);
    }

    public static void printParenthesis(int i, int j, int[][] bracket) {
        if (i == j) {
            System.out.print(name++);
            return;
        }

        System.out.print("(");
        printParenthesis(i, bracket[i][j], bracket);
        printParenthesis(bracket[i][j] + 1, j, bracket);
        System.out.print(")");
    }

    public static void main(String[] args) {
        int nums[] = {6, 11, 3, 12, 5, 51, 7};
        matrixChainOrder(nums, nums.length);
    }
}