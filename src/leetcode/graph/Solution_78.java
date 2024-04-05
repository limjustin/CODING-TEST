package leetcode.graph;

import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution_78 {
    private List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        answer.add(new ArrayList<>());

        for (int i = 1; i <= nums.length; i++) {
            dfs(nums,-1, i, new ArrayDeque<>());
        }

        return answer;
    }

    private void dfs(int[] nums, int num, int lenLimit, Deque<Integer> sub) {

        if (sub.size() == lenLimit) {
            answer.add(new ArrayList<>(sub));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (num < nums[i]) {
                sub.addLast(nums[i]);
                dfs(nums, nums[i], lenLimit, sub);
                sub.pollLast();
            }
        }
    }
}
