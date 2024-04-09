package leetcode.dynamic_programming;

import java.util.ArrayList;
import java.util.Map;

public class Solution_70 {
    private int[] dp;

    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;

        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
