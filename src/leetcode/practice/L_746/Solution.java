package leetcode.practice.L_746;

class Solution {

    private static int[] minCosts;

    public int minCostClimbingStairs(int[] cost) {
        // 우리가 저장해야할 정보
        // n번째 계단까지 올라왔을 때 최소 비용
        // 도착하는 방법 : n-1번째 계단까지 올라오고 1칸 올라오기 vs n-2번째 계단까지 올라오고 2칸 올라오기
        // 둘 중 작은 값으로 저장하기

        minCosts = new int[1001];
        minCosts[0] = cost[0];
        minCosts[1] = cost[1];

        // climbingStairsTopDown(cost, cost.length - 1);
        climbingStairsBottomUp(cost);
        return Integer.min(minCosts[cost.length - 1], minCosts[cost.length - 2]);
    }

    public Integer climbingStairsTopDown(int[] cost, int index) {

        if (index == 0 || index == 1)
            return minCosts[index];

        if (minCosts[index] == 0)
            minCosts[index] = Integer.min(climbingStairsTopDown(cost, index - 1), climbingStairsTopDown(cost, index - 2)) + cost[index];

        return minCosts[index];
    }

    public void climbingStairsBottomUp(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            minCosts[i] = Integer.min(minCosts[i - 1], minCosts[i - 2]) + cost[i];
        }
    }
}
