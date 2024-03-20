package leetcode.string_manipulation;

import java.util.*;

class Solution_819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 일단 소문자화
        paragraph = paragraph.toLowerCase();

        // String s = paragraph.replaceAll("[^A-Za-z ]", "");
        // String s2 = paragraph.replaceAll("[!?',:.]", "");
        // System.out.println("s2 = " + s2);

        // 특수문자 제거 (정규식 쓸거야?)
        String[] words = paragraph.split("[!?',;. ]");

        // dictionary 사용하는 것이 좋아보이는데
        Map<String, Integer> wordMap = new HashMap<>();
        List<String> bannedList = new ArrayList<>(Arrays.asList(banned));

        for (String word : words) {
            if (bannedList.contains(word) || word.isEmpty())
                continue;

            if (!wordMap.containsKey(word))  // 값이 없다면 초기화
                wordMap.put(word, 1);
            else                             // 이미 존재 한다면 +1
                wordMap.put(word, wordMap.get(word) + 1);

            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }


        wordMap.forEach((key, value) -> {
            System.out.println("key, value = " + key + " & " + value);
        });

        String result = "";
        int max = 0;

        for (String key : wordMap.keySet()) {
            if (wordMap.get(key) > max) {
                max = wordMap.get(key);
                result = key;
            }
        }

        return result;
    }
}
