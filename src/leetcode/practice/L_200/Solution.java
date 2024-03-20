package leetcode.practice.L_200;

public class Solution {

    private static boolean[][] visited;

    public int numIslands(char[][] grid) {

        visited = new boolean[grid.length][grid[0].length];

        int cnt = 0;

        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[m].length; n++) {
                if (!visited[m][n] && grid[m][n] == '1') {
                    dfs(grid, m, n);
                    cnt++;
                } else {
                    continue;
                }
            }
        }

        return cnt;
    }

    public void dfs(char[][] grid, int m, int n) {
        visited[m][n] = true;

        if (n - 1 >= 0) {
            if(!visited[m][n - 1] && grid[m][n - 1] == '1')
                dfs(grid, m, n - 1);
        }

        if (m - 1 >= 0) {
            if(!visited[m - 1][n] && grid[m - 1][n] == '1')
                dfs(grid, m - 1, n);
        }

        if (n + 1 <= grid[0].length - 1) {
            if(!visited[m][n + 1] && grid[m][n + 1] == '1')
                dfs(grid, m, n + 1);
        }

        // 리스트 범위를 움직일 때는 항상 out of bound 문제 생각!!
        if (m + 1 <= grid.length - 1) {
            if(!visited[m + 1][n] && grid[m + 1][n] == '1')
                dfs(grid, m + 1, n);
        }
    }
}
