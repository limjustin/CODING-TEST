package leetcode.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution_20 {
    public boolean isValid(String s) {
        // Stack
        Deque<Character> stack = new ArrayDeque<>();

        if (s.length() == 1)
            return false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 조건 다시 생각해보기
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty() && ((c == ')' || c == '}' || c == ']')))
                return false;

            char pop = stack.pop();
            if (!((c == ']' && pop == '[') || (c == '}' && pop == '{') || (c == ')' && pop == '('))) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
