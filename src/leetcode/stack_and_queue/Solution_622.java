package leetcode.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

class Solution_622 {

    Queue<Integer> queue;
    int size;
    int front = -1;
    int rear = -1;
    int cnt = 0;

    public Solution_622(int k) {
        queue = new LinkedList<>();
        size = k;
    }

    public boolean enQueue(int value) {
        if (size <= cnt)
            return false;

        if (cnt == 0)
            front = value;

        cnt++;
        queue.add(value);
        rear = value;
        return true;
    }

    public boolean deQueue() {
        if (front == -1 && rear == -1)
            return false;

        queue.remove();
        cnt--;

        if (cnt == 0) {
            front = -1;
            rear = -1;
        } else {
            front = queue.element();
        }

        return true;
    }

    public int Front() {
        return front;
    }

    public int Rear() {
        return rear;
    }

    public boolean isEmpty() {
        return (cnt == 0);
    }

    public boolean isFull() {
        if (size == cnt)
            return true;
        else
            return false;
    }
}
