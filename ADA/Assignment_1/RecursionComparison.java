import java.util.HashMap;
import java.util.Map;

public class RecursionComparison {

    static int factCalls = 0;
    static int fibCalls = 0;
    static int fibDpCalls = 0;

    // ----- Factorial -----
    public static int factorial(int value) {
        factCalls++;

        if (value == 0 || value == 1) {
            return 1;
        }

        int partial = factorial(value - 1);
        return value * partial;
    }

    // ----- Fibonacci (Naive) -----
    public static int fibonacci(int value) {
        fibCalls++;

        if (value <= 1) {
            return value;
        }

        int left = fibonacci(value - 1);
        int right = fibonacci(value - 2);

        return left + right;
    }

    // ----- Fibonacci (Memoization) -----
    public static int fibonacciDP(int value, Map<Integer, Integer> store) {
        fibDpCalls++;

        if (value <= 1) {
            return value;
        }

        if (store.containsKey(value)) {
            return store.get(value);
        }

        int ans = fibonacciDP(value - 1, store) + fibonacciDP(value - 2, store);
        store.put(value, ans);

        return ans;
    }

    public static void main(String[] args) {

        int[] testValues = {5, 10, 20, 30};

        System.out.println("=== CALL COUNT DATA ===");
        System.out.println("n,FactCalls,FibCalls,FibDPCalls");

        for (int num : testValues) {

            factCalls = 0;
            fibCalls = 0;
            fibDpCalls = 0;

            factorial(num);
            int factorialCount = factCalls;

            fibonacci(num);
            int fibCount = fibCalls;

            fibonacciDP(num, new HashMap<>());
            int dpCount = fibDpCalls;

            System.out.println(num + "," + factorialCount + "," + fibCount + "," + dpCount);
        }

        System.out.println("\n=== TIME ANALYSIS ===");
        System.out.println("n,Naive(ms),DP(ms)");

        for (int num : testValues) {

            fibCalls = 0;
            fibDpCalls = 0;

            long t1 = System.nanoTime();
            fibonacci(num);
            double timeNaive = (System.nanoTime() - t1) / 1_000_000.0;

            long t2 = System.nanoTime();
            fibonacciDP(num, new HashMap<>());
            double timeDP = (System.nanoTime() - t2) / 1_000_000.0;

            System.out.println(num + "," + timeNaive + "," + timeDP);
        }
    }
}