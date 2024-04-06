package leetcode.shortest_path;

import java.sql.SQLOutput;
import java.util.*;

public class Solution_743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Priority Queue
        Map<Integer, List<Integer>> networkMap = new HashMap<>();
        Map<List<Integer>, Integer> timeMap = new HashMap<>();

        for (int i = 0; i < times.length; i++) {
            int sourceNode = times[i][0];
            int targetNode = times[i][1];
            int time = times[i][2];

            timeMap.put(List.of(sourceNode, targetNode), time);

            if (!networkMap.containsKey(sourceNode)) {
                networkMap.put(sourceNode, new LinkedList<>(List.of(targetNode)));
            } else {
                List<Integer> list = networkMap.get(sourceNode);
                list.add(targetNode);
                networkMap.replace(sourceNode, list);
            }
        }

        return getTimeWithBFS(networkMap, timeMap, k, n);
    }

    public int getTimeWithBFS(Map<Integer, List<Integer>> networkMap, Map<List<Integer>, Integer> timeMap, int startNode, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        int answer = 0;
        boolean[] visited = new boolean[n + 1];
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            if (checkAllVisited(visited))
                break;

            int max = 0;
            int sourceNode = queue.poll();
            System.out.println("sourceNode = " + sourceNode);

            if (networkMap.get(sourceNode) != null) {
                for (Integer targetNode : networkMap.get(sourceNode)) {
                    System.out.println("targetNode = " + targetNode);
                    if (!visited[targetNode]){
                        queue.add(targetNode);
                        visited[targetNode] = true;

                        if (max < timeMap.get(List.of(sourceNode, targetNode)))
                            max = timeMap.get(List.of(sourceNode, targetNode));
                    }
                }
                answer += max;
            }
        }

        if (!checkAllVisited(visited))
            return -1;

        return answer;
    }

    public boolean checkAllVisited(boolean[] visited) {
        for (int i = 1; i <= visited.length - 1; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }
}
