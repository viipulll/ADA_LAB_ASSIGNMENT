public class LCS {

    public static void computeLCS(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // ----- Build DP Table -----
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println("Length of LCS = " + dp[n][m]);

        // ----- Backtracking -----
        int i = n, j = m;
        StringBuilder lcs = new StringBuilder();

        while (i > 0 && j > 0) {

            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            } 
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } 
            else {
                j--;
            }
        }

        System.out.println("LCS String = " + lcs.toString());
    }

    public static void main(String[] args) {

        // 🔥 Changed input strings
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";

        computeLCS(str1, str2);
    }
}