package leetcode.practice.L_62;

class Solution {

    private static int[][] grid;

    public int uniquePaths(int m, int n) {
        grid = new int[m][n];

        // 모서리 채우기
        for (int x = 0; x < m; x++)
            grid[x][0] = 1;

        for (int y = 0; y < n; y++)
            grid[0][y] = 1;

        dp(m - 1, n - 1);

        return grid[m - 1][n - 1];
    }

    private Integer dp(int m, int n) {
        System.out.println("m, n = " + m + ", " + n);
        if (m == 0 || n == 0)
            return grid[m][n];

        if (grid[m][n] == 0)
            grid[m][n] = dp(m - 1, n) + dp(m, n - 1);

        return grid[m][n];
    }
}
