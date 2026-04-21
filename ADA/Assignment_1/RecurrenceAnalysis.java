public class RecurrenceAnalysis {

    static int callsT1 = 0;
    static int callsT2 = 0;

    // ----- T(n) = T(n/2) + n -----
    public static int T1(int value) {

        callsT1++;

        if (value <= 1) {
            return 1;
        }

        // simulate O(n) work
        int counter = 0;
        while (counter < value) {
            counter++;
        }

        int result = T1(value / 2) + value;
        return result;
    }

    // ----- T(n) = 2T(n/2) + n -----
    public static int T2(int value) {

        callsT2++;

        if (value <= 1) {
            return 1;
        }

        // simulate O(n) work
        for (int i = 0; i < value; i++) {
            // intentional empty work
        }

        int left = T2(value / 2);
        int right = T2(value / 2);

        return left + right + value;
    }

    public static void main(String[] args) {

        int[] testSizes = {8, 16, 32, 64, 128, 256};

        System.out.println("=== CALL COUNT ===");
        System.out.println("n,T1 Calls,T2 Calls");

        for (int n : testSizes) {

            callsT1 = 0;
            callsT2 = 0;

            T1(n);
            int count1 = callsT1;

            T2(n);
            int count2 = callsT2;

            System.out.println(n + "," + count1 + "," + count2);
        }

        System.out.println("\n=== TIME ANALYSIS ===");
        System.out.println("n,T1(ms),T2(ms)");

        for (int n : testSizes) {

            callsT1 = 0;
            callsT2 = 0;

            long tStart = System.nanoTime();
            T1(n);
            double time1 = (System.nanoTime() - tStart) / 1_000_000.0;

            long tEnd = System.nanoTime();
            T2(n);
            double time2 = (System.nanoTime() - tEnd) / 1_000_000.0;

            System.out.println(n + "," + time1 + "," + time2);
        }
    }
}