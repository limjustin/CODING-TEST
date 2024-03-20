package leetcode.practice.L_1091;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 0}
        };
        int[][] grid2 = new int[][]{
                {0, 1},
                {1, 0}
        };
        int[][] grid3 = new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 1}
        };
        int[][] grid4 = new int[][]{
                {0, 0, 1, 0},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {0, 0, 0, 0}
        };
        int i = solution.shortestPathBinaryMatrix(grid4);
        System.out.println(i);
    }
}
