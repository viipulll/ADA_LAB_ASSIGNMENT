public class FloydWarshall {

    static final int INF = 9999;

    void computeShortestPaths(int[][] graph) {

        int n = graph.length;
        int[][] dist = new int[n][n];

        // ----- Copy original matrix -----
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // ----- Floyd Warshall Algorithm -----
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (dist[i][k] != INF && dist[k][j] != INF) {

                        int newDist = dist[i][k] + dist[k][j];

                        if (newDist < dist[i][j]) {
                            dist[i][j] = newDist;
                        }
                    }
                }
            }
        }

        display(dist);
    }

    void display(int[][] matrix) {

        System.out.println("Shortest Distance Matrix:");

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {

                if (matrix[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] graph = {
            {0, 4, INF, 7},
            {8, 0, 2, INF},
            {5, INF, 0, 1},
            {2, INF, INF, 0}
        };

        FloydWarshall obj = new FloydWarshall();
        obj.computeShortestPaths(graph);
    }
}