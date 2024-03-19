package leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    private static List<List<Integer>> answer;
    private static int k;

    public static void main(String[] args) {
        answer = new ArrayList<>();
        k = 3;
        combination(List.of(1, 2, 3, 4));
        System.out.println(answer.size());
    }

    private static void combination(List<Integer> nums) {
        backtracking(0, nums, new ArrayList<>());
    }

    private static void backtracking(int start, List<Integer> nums, List<Integer> current) {
        if (current.size() == k) {
            answer.add(current);
            return;
        }

        for (int i = start; i < nums.size(); i++) {
            current.add(nums.get(i));
            backtracking(i + 1, nums, current);
            current.remove(current.size() - 1);
        }
    }
}
