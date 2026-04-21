import java.util.*;

public class Dijkstra {

    static final int N = 6;

    int getMin(int distance[], boolean visited[]) {
        int min = Integer.MAX_VALUE, index = -1;

        for (int idx = 1; idx < N; idx++) {
            if (!visited[idx] && distance[idx] < min) {
                min = distance[idx];
                index = idx;
            }
        }
        return index;
    }

    void findPath(int graph[][], int source) {

        int distance[] = new int[N];
        boolean visited[] = new boolean[N];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 1;

        for (int idx = 0; idx < N - 2; idx++) {
            int u = getMin(distance, visited);
            visited[u] = true;

            for (int v = 1; v < N; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                    distance[u] != Integer.MAX_VALUE &&
                    distance[u] + graph[u][v] < distance[v]) {

                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        System.out.println("Node \t Shortest Distance");
        for (int idx = 0; idx < N; idx++)
            System.out.println(idx + " \t\t " + distance[idx]);
    }

    public static void main(String[] args) {

        int matrix[][] = {
            {0, 5, 1, 1, 8, 0},
            {4, 0, 6, 0, 0, 0},
            {1, 6, 1, 3, 0, 5},
            {0, 0, 3, 0, 8, 3},
            {8, 0, 1, 7, 0, 9},
            {1, 0, 5, 3, 10, 1}
        };

        Dijkstra sp = new Dijkstra();
        sp.findPath(matrix, 1);
    }
}