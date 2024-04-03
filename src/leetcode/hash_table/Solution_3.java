package leetcode.hash_table;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> stringHashMap = new HashMap<>();

        int max = 0;
        int len = 0;
        int idx = 0;

        for (char c : s.toCharArray()) {
            if (!stringHashMap.containsKey(c)) {
                len++;
                stringHashMap.put(c, idx);
            } else {
                int sameCharGap = idx - stringHashMap.get(c);
                int plainCharlen = len + 1;
                len = Math.min(sameCharGap, plainCharlen);
                stringHashMap.replace(c, idx);
            }

            if (len > max)
                max = len;

            idx++;
        }

        return max;
    }
}
