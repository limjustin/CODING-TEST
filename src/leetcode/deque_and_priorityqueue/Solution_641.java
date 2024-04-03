package leetcode.deque_and_priorityqueue;

import java.util.Deque;
import java.util.LinkedList;

class Solution_641 {

    Deque<Integer> deque;
    int size = 0;
    int front = -1;
    int rear = -1;
    int currentLength = 0;

    public Solution_641(int k) {
        deque = new LinkedList<>();
        size = k;
    }

    public boolean insertFront(int value) {
        if (size <= currentLength)
            return false;

        if (currentLength == 0)
            rear = value;

        deque.addFirst(value);
        currentLength++;
        front = value;

        return true;
    }

    public boolean insertLast(int value) {
        if (size <= currentLength)
            return false;


        if (currentLength == 0)
            front = value;

        deque.addLast(value);
        currentLength++;
        rear = value;

        return true;
    }

    public boolean deleteFront() {
        if (currentLength == 0)
            return false;

        deque.removeFirst();
        currentLength--;

        if (deque.peekFirst() == null) {
            front = -1;
            rear = -1;
        }
        else {
            front = deque.peekFirst();
        }

        return true;
    }

    public boolean deleteLast() {
        if (currentLength == 0)
            return false;

        deque.removeLast();
        currentLength--;

        if (deque.peekLast() == null) {
            front = -1;
            rear = -1;
        } else {
            rear = deque.getLast();
        }

        return true;
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    public boolean isEmpty() {
        return (currentLength == 0);
    }

    public boolean isFull() {
        return (currentLength == size);
    }
}
