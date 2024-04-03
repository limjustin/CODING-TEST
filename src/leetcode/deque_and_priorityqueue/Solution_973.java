package leetcode.deque_and_priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution_973 {
    static class Point {
        double distance;
        int[] point;

        public Point(double distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(value -> value.distance));

        for (int i = 0; i < points.length; i++) {
            int[] arr = new int[2];
            arr[0] = points[i][0];
            arr[1] = points[i][1];
            double distance = Math.sqrt((long) arr[0] * arr[0] + (long) arr[1] * arr[1]);

            priorityQueue.add(new Point(distance, arr));
        }

        int[][] result = new int[k][];

        for (int i = 0; i < k; i++) {
            if (priorityQueue.peek() != null)
                result[i] = priorityQueue.poll().point;
        }

        return result;
    }
}
