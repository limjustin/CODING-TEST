package leetcode.dynamic_programming;

public class Solution_42897 {
    public int solution(int[] money) {
        int answer = 0;

        int[] house = new int[money.length + 2];
        int i = 0;
        while (i < money.length) {
            house[i] = money[i];
            i++;
        }

        house[i] = money[0];
        house[i + 1] = money[1];

        int[] dp = new int[money.length];
        dp[0] = house[0];
        dp[1] = Math.max(dp[0], house[1]);

        for (int idx = 2; idx < dp.length; idx++) {
            dp[idx] = Math.max(dp[idx - 1], dp[idx - 2] + house[idx]);
        }

        return answer;
    }
}
