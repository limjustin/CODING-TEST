package leetcode.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

class Solution_206 {
    public ListNode reverseList(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        ListNode node = head;
        ListNode res = head;
        while (node != null) {
            deque.add(node.val);
            node = node.next;
        }

        while (head != null) {
            head.val = deque.pollLast();
            head = head.next;
        }

        while (res != null) {
            System.out.println(res.val);
        }

        return head;
    }
}
