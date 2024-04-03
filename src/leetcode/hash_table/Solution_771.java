package leetcode.hash_table;

import java.util.HashMap;
import java.util.Map;

class Solution_771 {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> stonesMap = new HashMap<>();
        for (int i = 0; i < stones.length(); i++) {
            if (stonesMap.containsKey(stones.charAt(i)))
                stonesMap.replace(stones.charAt(i), stonesMap.get(stones.charAt(i)) + 1);
            else
                stonesMap.put(stones.charAt(i), 1);
        }

        for (char c : stonesMap.keySet()) {
            System.out.print("key = " + c);
            System.out.println(stonesMap.get(c));
        }

        int output = 0;
        for (int i = 0; i < jewels.length(); i++) {
            if (stonesMap.containsKey(jewels.charAt(i)))
                output = output + stonesMap.get(jewels.charAt(i));
        }

        return output;
    }
}
