package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Input : int n
        int[] dp = new int[n + 1];
        int result = sugarDelivery(n, dp);

        if (result >= 5000)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    public static int sugarDelivery(int n, int[] dp) {
        if (dp[n] != 0)
            return dp[n];

        if (n == 3 || n == 5)
            return 1;
        else if (n == 1 || n == 2 || n == 4)
            return 5001;

        dp[n] = Math.min(sugarDelivery(n - 3, dp), sugarDelivery(n - 5, dp)) + 1;
        return dp[n];
    }
}
