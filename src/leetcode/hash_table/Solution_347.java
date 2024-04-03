package leetcode.hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsHashMap = new HashMap<>();
        for (int num : nums) {
            if (!numsHashMap.containsKey(num))
                numsHashMap.put(num, 1);
            else
                numsHashMap.replace(num, numsHashMap.get(num) + 1);
        }

        List<Integer> sortResult = new ArrayList<>(numsHashMap.keySet());
        sortResult.sort(((o1, o2) ->
            numsHashMap.get(o2).compareTo(numsHashMap.get(o1))
        ));

        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = sortResult.get(i);

        return result;
    }
}
