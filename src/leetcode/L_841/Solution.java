package leetcode.L_841;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    private static List<List<Integer>> roomList;
    private static boolean[] visited;
    private static Queue<Integer> queue;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        roomList = rooms;
        visited = new boolean[rooms.size()];
        queue = new LinkedList<>();

        visited[0] = true;
        unlockRoom(rooms.get(0));

        // 방문 안 한 방이 한 개라도 남아 있다면
        for (int i = 0; i < rooms.size(); i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }

    public void unlockRoom(List<Integer> roomKeys) {
        queue.addAll(roomKeys);

        while (!queue.isEmpty()) {
            int keyOfIndex = queue.poll();
            dfs(keyOfIndex);

        }
    }

    public void dfs(int index) {
        visited[index] = true;
        for (int key : roomList.get(index))
            if (!visited[key])
                dfs(key);
    }
}
