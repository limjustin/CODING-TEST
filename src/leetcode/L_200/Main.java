package leetcode.L_200;

public class Main {
    public static void main(String[] args) {
        char[][] grid1 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };

        char[][] grid2 = new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid2));
    }
}
