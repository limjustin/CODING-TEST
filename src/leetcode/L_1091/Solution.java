package leetcode.L_1091;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    private static boolean[][] visited;
    private static Queue<List<Integer>> queue;

    private static int maxX;
    private static int maxY;

    public int shortestPathBinaryMatrix(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        queue = new LinkedList<>();

        maxX = grid.length - 1;
        maxY = grid[0].length - 1;

        // System.out.println("grid[0][0] = " + grid[0][0]);
        if (grid[0][0] == 1)
            return -1;

        return bfs(grid, 0, 0, 1);
    }

    public int bfs(int[][] grid, int x, int y, int len) {

        int finalX = 0;
        int finalY = 0;
        int resultLength = -1;

        // TODO : Queue 에서 좌표 2개 다루기
        visited[x][y] = true;
        queue.add(Arrays.asList(x, y, len));  // List 형태로 저장

        while (!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            int pollX = poll.get(0);
            int pollY = poll.get(1);
            int curLen = poll.get(2);
            System.out.println("x, y, curLen = " + pollX + ", " + pollY + ", " + curLen);

            // 8방위 좌표 처리를 어떻게 할 것인가
            for (int toX = -1; toX <= 1; toX++) {
                for (int toY = -1; toY <= 1; toY++) {
                    if ((toX == 0 && toY == 0) || (pollX + toX) < 0 || (pollX + toX) > maxX || (pollY + toY) < 0 || (pollY + toY) > maxY)
                        continue;

                    if (!visited[(pollX + toX)][(pollY + toY)] && grid[(pollX + toX)][(pollY + toY)] == 0) {
                        System.out.println("(pollX + toX) = " + (pollX + toX));  // 문자열 처리 뭐임
                        System.out.println("(pollY + toY) = " + (pollY + toY));
                        visited[(pollX + toX)][(pollY + toY)] = true;
                        queue.add(Arrays.asList((pollX + toX), (pollY + toY), curLen + 1));
                    }
                }
            }

            if (pollX == maxX && pollY == maxY)
                return curLen;

            finalX = pollX;
            finalY = pollY;
            resultLength = curLen;
        }

        if (finalX != maxX || finalY != maxY)
            return -1;

        return resultLength;
    }
}
