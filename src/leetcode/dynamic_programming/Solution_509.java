package leetcode.dynamic_programming;

public class Solution_509 {
    public int fibBruteForce(int n) {

        if (n <= 1)
            return n;

        return fibBruteForce(n - 1) + fibBruteForce(n - 2);
    }

    public int fibTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int fibMemoization(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        fibRecursive(n, dp);
        return dp[n];
    }

    public int fibRecursive(int i, int[] dp) {
        if (i <= 1)
            return i;

        if (dp[i] != 0)
            return dp[i];

        dp[i] = fibRecursive(i - 1, dp) + fibRecursive(i - 2, dp);
        return dp[i];
    }
}
