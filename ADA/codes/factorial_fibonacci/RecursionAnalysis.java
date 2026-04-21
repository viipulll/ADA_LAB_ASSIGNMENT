import java.util.HashMap;
import java.util.Map;

public class RecursionAnalysis {

    static int fibCalls = 0;
    static int fibDpCalls = 0;

    // ----- Basic Recursive Fibonacci -----
    static int fibonacci(int num) {
        fibCalls++;

        if (num == 0 || num == 1) {
            return num;
        }

        int left = fibonacci(num - 1);
        int right = fibonacci(num - 2);

        return left + right;
    }

    // ----- Fibonacci using Memoization -----
    static int fibonacciDP(int num, Map<Integer, Integer> cache) {
        fibDpCalls++;

        if (num <= 1) {
            return num;
        }

        if (cache.containsKey(num)) {
            return cache.get(num);
        }

        int val1 = fibonacciDP(num - 1, cache);
        int val2 = fibonacciDP(num - 2, cache);

        int finalAns = val1 + val2;
        cache.put(num, finalAns);

        return finalAns;
    }

    public static void main(String[] args) {

        int[] inputSizes = {5, 10, 20, 30};

        // ----- Time Measurement Section -----
        System.out.println("=== TIME ANALYSIS ===");
        System.out.println("n,Recursive(ms),DP(ms)");

        for (int current : inputSizes) {

            fibCalls = 0;
            fibDpCalls = 0;

            long startTime = System.nanoTime();
            fibonacci(current);
            long endTime = System.nanoTime();
            double recTime = (endTime - startTime) / 1000000.0;

            startTime = System.nanoTime();
            fibonacciDP(current, new HashMap<>());
            endTime = System.nanoTime();
            double dpTime = (endTime - startTime) / 1000000.0;

            System.out.println(current + "," + recTime + "," + dpTime);
        }

        // ----- Call Count Section -----
        System.out.println("\n=== CALL COUNT ANALYSIS ===");
        System.out.println("n,RecursiveCalls,DPCalls");

        for (int current : inputSizes) {

            fibCalls = 0;
            fibDpCalls = 0;

            fibonacci(current);
            int recCalls = fibCalls;

            fibonacciDP(current, new HashMap<>());
            int dpCalls = fibDpCalls;

            System.out.println(current + "," + recCalls + "," + dpCalls);
        }
    }
}