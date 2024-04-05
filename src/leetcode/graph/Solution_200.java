package leetcode.graph;

class Solution_200 {
    private int[] dX;
    private int[] dY;
    private int newX;
    private int newY;

    public int numIslands(char[][] grid) {
        // 주변을 DFS로 탐색
        // 4방향만 보면 된다

        dX = new int[]{
                -1, 1, 0, 0
        };

        dY = new int[]{
                0, 0, -1, 1
        };

        newX = 0;
        newY = 0;

        int cnt = 0;
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if (grid[m][n] == '1') {
                    searchWithDFS(grid, m, n);
                    cnt++;
                }
            }
        }

        System.out.println("cnt = " + cnt);
        return cnt;
    }

    private void searchWithDFS(char[][] grid, int m, int n) {
        System.out.println("---------");
        System.out.println("m = " + m);
        System.out.println("n = " + n);
        grid[m][n] = '0';

        for (int i = 0; i < 4; i++) {
            newX = m + dX[i];
            newY = n + dY[i];

            if (newX < 0 || newX > grid.length - 1)
                continue;

            if (newY < 0 || newY > grid[0].length - 1)
                continue;

            if (grid[newX][newY] == '1')
                searchWithDFS(grid, newX, newY);
        }
    }
}
