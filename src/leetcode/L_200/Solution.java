package leetcode.L_200;

public class Solution {

    public int numIslands(char[][] grid) {
        // 어떻게 입력을 받을건지
        // 탐색은 어떻게 진행할건지
        // 탐색은 x좌표 + 1, y좌표 + 1

        // 탐색을 진행하는데
        // 1이면 계속 재귀로 가기
        // 0이면 나오기
        int cnt = 0;

        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[m].length; n++) {
                if (grid[m][n] == '1') {
                    dfs(grid, m, n);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void dfs(char[][] grid, int m, int n) {
        if (m < 0 || m >= grid.length || n < 0 || n >= grid[0].length || grid[m][n] == '0')
            return;
        grid[m][n] = '0';  // 이거 어케 생각해
        dfs(grid, m, n + 1);
        dfs(grid, m, n - 1);
        dfs(grid, m + 1, n);
        dfs(grid, m - 1, n);

//        if ((n + 1) >= grid[0].length) {
//
//        } else if (grid[m][n + 1] == '1') {
//            // System.out.println("n + 1");
//            dfs(grid, m, n + 1);
//        }
//
//        if ((m + 1) >= grid.length) {
//
//        } else if (grid[m + 1][n] == '1') {
//            // System.out.println("m + 1");
//            dfs(grid, m + 1, n);
//        }
    }
}
