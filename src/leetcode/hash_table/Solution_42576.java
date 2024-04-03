package leetcode.hash_table;

import java.util.Map;
import java.util.HashMap;

class Solution_42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> participants = new HashMap<>();
        for (String p : participant) {
            participants.put(p, participants.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            if (participants.containsKey(c)) {
                participants.replace(c, participants.get(c) - 1);
            }
        }

        for (String name : participants.keySet()) {
            if (participants.get(name) == 1)
                answer = name;
        }

        return answer;
    }
}
