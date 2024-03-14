package leetcode.L_125;

class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {

            if (!Character.isLetterOrDigit(str.charAt(start))) {
                start++;
                continue;
            }

            if (!Character.isLetterOrDigit(str.charAt(end))) {
                end--;
                continue;
            }

            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}
