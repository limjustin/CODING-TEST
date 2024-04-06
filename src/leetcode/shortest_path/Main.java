package leetcode.shortest_path;

public class Main {
    public static void main(String[] args) {
        int[][] times = new int[][]{
                {1, 2, 1},
                {2, 3, 1},
                {1, 3, 4}
        };

        Solution_743 solution743 = new Solution_743();
        System.out.println(solution743.networkDelayTime(times, 3, 1));
    }
}
