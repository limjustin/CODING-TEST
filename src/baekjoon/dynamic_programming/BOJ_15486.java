package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] prices = new int[n][2];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            prices[i][0] = Integer.parseInt(input.split(" ")[0]);
            prices[i][1] = Integer.parseInt(input.split(" ")[1]);
        }

        consult(n, prices);
    }

    public static void consult(int n, int[][] prices) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        int maxPrice = 0;

        for (int i = 0; i <= n - 1; i++) {
            int day = prices[i][0];

            int idx = i;
            while (idx >= 0) {
                if (idx == 0) {
                    dp[i] = 0;
                    break;
                } else if (dp[idx] != 0) {
                    dp[i] = dp[idx];
                    System.out.println("dp[" + i + "] = " + dp[idx]);
                    break;
                } else if (dp[idx] == 0) {
                    idx--;
                }
            }

            int expectPrice = dp[i] + prices[i][1];

            if ((i + day) > n) {
                continue;
            } else {
                if (expectPrice > dp[i + day])
                    dp[i + day] = expectPrice;

                if (expectPrice > maxPrice)
                    maxPrice = expectPrice;
            }
        }

        System.out.println("maxPrice = " + maxPrice);
    }
}