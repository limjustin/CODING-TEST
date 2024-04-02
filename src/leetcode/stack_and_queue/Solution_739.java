package leetcode.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        // 브루트 포스로 풀면 O(n^2) 나온다
        // stack : (2,75) (3,71)
        // 스택에 가장 마지막에 있는 key의 value보다 값이 작으면 넣기
        // 크다면 해당 인덱스 가져와서 배열 값을 인덱스의 차이만큼 넣기
        // (0,73) (1,74) (2,75) (3,71) (4,69) (5,72)

        int[] results = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && (temperatures[stack.getLast()] < temperatures[i])) {
                results[stack.getLast()] = (i - stack.getLast());
                stack.poll();
            }
            stack.add(i);
        }

        return results;
    }
}
