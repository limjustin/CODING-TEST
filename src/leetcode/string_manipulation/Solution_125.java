package leetcode.string_manipulation;

class Solution_125 {
    public boolean isPalindrome(String s) {
        // 문자가 아니면 인덱스 +1 혹은 -1
        // 인덱스가 같아지거나 역전되면 끝남
        // while (start < end)

        int start = 0;  // 시작 인덱스
        int end = s.length() - 1;  // 끝 인덱스

        s = s.toLowerCase();

        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }

            if (s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}
