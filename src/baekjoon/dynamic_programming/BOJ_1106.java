package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1106 {
    public static void main(String[] args) throws IOException  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        int c = Integer.parseInt(input1.split(" ")[0]);
        int n = Integer.parseInt(input1.split(" ")[1]);

        int[][] cities = new int[n][2];

        for (int i = 0; i < n; i++) {
            String input2 = br.readLine();
            cities[i][0] = Integer.parseInt(input2.split(" ")[0]);
            cities[i][1] = Integer.parseInt(input2.split(" ")[1]);
        }

        System.out.println(hotel(c, cities));
    }

    private static int hotel(int c, int[][] cities) {
        int[] dp = new int[c + 1];

        for (int i = 1; i <= c; i++) {
            dp[i] = calculate(i, dp, cities);
            System.out.println("dp[" + i + "] = " + dp[i]);
        }

        return dp[c];
    }

    private static int calculate(int n, int[] dp, int[][] cities) {
        int min = 101;

        for (int[] city : cities) {
            int money = city[0];
            int count = city[1];

            int res = 0;

            if (n - count < 0)
                res = money;
            else
                res = dp[n - count] + money;

            if (min > res)
                min = res;
        }

        return min;
    }
}
