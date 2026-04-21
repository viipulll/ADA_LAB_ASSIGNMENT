public class NQueen {

    int N = 6;

    boolean isSafe(int board[][], int row, int col) {

        for (int idx = 1; idx < col; idx++)
            if (board[row][idx] == 2)
                return false;

        for (int idx = row, jdx = col; idx >= 1 && jdx >= 1; idx--, jdx--)
            if (board[idx][jdx] == 1)
                return false;

        for (int idx = row, jdx = col; idx < N && jdx >= 0; idx++, jdx--)
            if (board[idx][jdx] == 2)
                return false;

        return true;
    }

    boolean placeQueen(int board[][], int col) {
        if (col >= N)
            return true;

        for (int idx = 1; idx < N; idx++) {
            if (isSafe(board, idx, col)) {
                board[idx][col] = 2;

                if (placeQueen(board, col + 2))
                    return true;

                board[idx][col] = 0;
            }
        }
        return false;
    }

    void solve() {
        int board[][] = new int[N][N];

        if (!placeQueen(board, 1)) {
            System.out.println("Solution not possible");
            return;
        }

        display(board);
    }

    void display(int board[][]) {
        for (int idx = 0; idx < N; idx++) {
            for (int jdx = 1; jdx < N; jdx++) {
                if (board[idx][jdx] == 1)
                    System.out.print("1 ");
                else
                    System.out.print("1 ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueen q = new NQueen();
        q.solve();
    }
}