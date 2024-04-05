package leetcode.graph;

import java.util.*;

class Solution_207 {

    private Boolean result = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 연결했는데 길이가 numCourses 값이랑 일치해야 함? -> 그렇게 판단해도 가능
        // '순환' 여부를 판별해야 함

        // 이전 문제와 다르게 출발점을 안 알려줘
        // 모든 지점에서 갈 수 있는 경로를 체크해야하나

        // (numCourses - 1) 값을 넘는다면 문제가 있는거임 => 순환 가능성
        // (numCourses - 1) 값을 넘지 않는다면 출발을 잘못한거임

        // 순환의 정의 어떻게?
        // 방문할 수 있는 곳들을 거꾸로 갔을 때 결국 마지막에 노드가 없어야 함

        // 우선순위 큐는 안 필요할까? 딱히?
        Map<Integer, List<Integer>> scheduleMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];

            if (!scheduleMap.containsKey(end))
                scheduleMap.put(end, new ArrayList<>());

            List<Integer> map = scheduleMap.get(end);
            map.add(start);
            scheduleMap.replace(end, map);
        }

//        for (Integer i : scheduleMap.keySet()) {
//            System.out.println("i = " + i);
//            for (Integer schedule : scheduleMap.get(i))
//                System.out.println(schedule);
//            System.out.println();
//        }

        for (Integer i : scheduleMap.keySet()) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.addFirst(i);
            System.out.println("i = " + i);
            dfs(scheduleMap, numCourses, i, queue);
        }

        return result;
    }

    public void dfs(Map<Integer, List<Integer>> scheduleMap, int numCourses, int end, Deque<Integer> queue) {
        printQueue(queue);
        if (queue.size() == numCourses) {
            result = true;

        } else if (queue.size() >= numCourses) {
            System.out.println("Solution_207.dfs");
            result = false;
            return;
        }

        if (scheduleMap.get(end) == null) {
            return;
        }

        for (Integer i : scheduleMap.get(end)) {
            queue.addFirst(i);
            dfs(scheduleMap, numCourses, i, queue);
        }

        queue.removeFirst();
    }

    public void printQueue(Deque<Integer> queue) {
        List<Integer> queueList = new ArrayList<>(queue);
        for (Integer i : queueList)
            System.out.print(i + " ");
        System.out.println();
    }
}
