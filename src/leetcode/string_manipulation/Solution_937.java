package leetcode.string_manipulation;

import java.util.ArrayList;
import java.util.List;

class Solution_937 {
    public String[] reorderLogFiles(String[] logs) {
        // 두번째 단어를 파악하는 것이 중요
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        // 문자 로그와 숫자 로그 분리
        for (String log : logs) {
            if (Character.isLetter(log.split(" ")[1].charAt(0))) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }

        letterLogs.sort((o1, o2) -> {
            String identifier1 = o1.split(" ")[0] + " ";
            String identifier2 = o2.split(" ")[0] + " ";
            String s1 = o1.replace(identifier1, "");
            String s2 = o2.replace(identifier2, "");

            if (s1.compareTo(s2) == 0)
                return identifier1.compareTo(identifier2);

            return s1.compareTo(s2);
        });

        letterLogs.addAll(digitLogs);

        return letterLogs.toArray(new String[0]);
    }
}
