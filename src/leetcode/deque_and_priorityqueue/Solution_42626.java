package leetcode.deque_and_priorityqueue;

import java.util.PriorityQueue;

public class Solution_42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int s : scoville)
            priorityQueue.add(s);

        int cnt = 0;

        if (priorityQueue.peek() != null) {
            while (priorityQueue.peek() < K) {
                if (priorityQueue.size() == 1)
                    return -1;

                int s1 = priorityQueue.poll();
                int s2 = priorityQueue.poll();

                priorityQueue.add(s1 + s2 * 2);
                cnt++;
            }
        }

        answer = cnt;

        return answer;
    }
}
