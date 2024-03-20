package leetcode.practice.L_70;

class Solution {

    private static int[] memo;

    public int climbStairs(int n) {
        // 1 아니면 2로 쪼개서 생각해야하네
        // 값을 점점 줄여서 접근해야 할 것 같아
        // 5라면 4 + 1 혹은 3 + 2 이렇게
        // 4라면 3 + 1 혹은 2 + 2
        // 1111 121 211 112 1111 211 22
        // 이건 Top-down 방식 같은데?
        // 3 (+1) (+2)
        // 2+1 1+2
        // 4 (+1) (+2)
        // 3+1  2+2

        // 4를 3+1 2+2 로 나눈다는거 자체가
        // 3이랑 2로 나눈다는 뜻임! (어차피 +1과 +2는 카운팅 1번만 되니까)

        memo = new int[46];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;

        return dp(n);
    }

    public Integer dp(int n) {

        if (n == 1 || n == 2)
            return memo[n];

        if (memo[n] == 0) {
            memo[n] = dp(n - 1) + dp(n - 2);
        }

        return memo[n];
    }
}
