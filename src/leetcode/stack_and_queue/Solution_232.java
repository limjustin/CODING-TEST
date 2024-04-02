package leetcode.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution_232 {

    Deque<Integer> stack;
    Deque<Integer> tempStack;


    public Solution_232() {
        stack = new ArrayDeque<>();
        tempStack = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!stack.isEmpty()) {
            tempStack.add(stack.removeLast());
        }

        stack.add(x);

        while (!tempStack.isEmpty()) {
            stack.add(tempStack.removeLast());
        }
    }

    public int pop() {
        return stack.removeLast();
    }

    public int peek() {
        return stack.getLast();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
