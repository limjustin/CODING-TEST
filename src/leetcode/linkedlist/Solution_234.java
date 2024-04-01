package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution_234 {
    public boolean isPalindrome(ListNode head) {
        // 팝 하면서 맨 앞에 노드와 비교
        List<Integer> nodes = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nodes.add(node.val);
            node = node.next;
        }

        int i = nodes.size() - 1;
        while (head != null) {
            if (nodes.get(i) != head.val) {
                return false;
            } else {
                i--;
                head = head.next;
            }
        }

        return true;
    }

    public boolean isPalindrome_Deque(ListNode head) {
        // 팝 하면서 맨 앞에 노드와 비교
        Deque<Integer> deque = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            deque.add(node.val);
            node = node.next;
        }

        while (!deque.isEmpty() && deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast())
                return false;
        }

        return true;
    }
}
