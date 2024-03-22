package leetcode.string_manipulation;

class Solution_344 {
    public void reverseString(char[] s) {
        // 배열 쭉 늘리고 맨 위랑 아래 바꾸기
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            swap(s, start, end);
            start++;
            end--;
        }

        System.out.print("[");
        for (int i = 0; i < s.length; i++) {
            System.out.print("\"" + s[i] + "\"");

            if (i != (s.length - 1))
                System.out.print(",");
        }
        System.out.println("]");
    }

    public void swap(char[] s, int start, int end) {
        char temp = ' ';
        temp = s[start];
        s[start] = s[end];
        s[end] = temp;
    }
}
