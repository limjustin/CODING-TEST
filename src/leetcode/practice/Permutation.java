package leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    private static List<List<Integer>> answer;

    public static void main(String[] args) {
        answer = new ArrayList<>();
        permute(List.of(1, 2, 3, 4));
        System.out.println(answer.size());
    }

    private static void permute(List<Integer> nums) {
        backtrack(nums, new ArrayList<>());
    }

    private static void backtrack(List<Integer> nums, List<Integer> current) {
        if (current.size() == nums.size()) {
            answer.add(current);
            return;
        }

        for (Integer num : nums) {
            if (!current.contains(num)) {
                current.add(num);
                backtrack(nums, current);
                current.remove(current.size() - 1);
            }
        }
    }
}
