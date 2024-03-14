package leetcode.L_200;

import leetcode.L_200.Solution;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        char[][] grid2 = {
                {'1'}, {'1'}
        };
        int result = solution.numIslands(grid2);
        System.out.println("result = " + result);
    }
}
