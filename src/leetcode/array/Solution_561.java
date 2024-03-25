package leetcode.array;

import java.util.Arrays;

class Solution_561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int result = 0;

        for (int i = 0; i < nums.length - 1; i = i + 2) {
            result += nums[i];
        }

        return result;
    }
}
