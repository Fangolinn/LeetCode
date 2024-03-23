/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // public class ListNode {
    // int val;
    // ListNode next;

    // ListNode() {
    // }

    // ListNode(int val) {
    // this.val = val;
    // }

    // ListNode(int val, ListNode next) {
    // this.val = val;
    // this.next = next;
    // }
    // }

    public ListNode reverse(ListNode head, ListNode prevNode) {
        if (prevNode instanceof ListNode) {
            head = head.next;
        }

        while (head != null) {
            ListNode tmpNext = head.next;
            head.next = prevNode;
            prevNode = head;
            head = tmpNext;
        }

        return prevNode;
    }

    public void v1(ListNode head) {
        // Reversed the list in a way that both lists are still connected here
        ListNode turtle = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
        }

        ListNode tail = reverse(turtle, turtle);

        while (head.next != tail && head != tail) {
            ListNode tmpNext = tail.next;

            tail.next = head.next;
            head.next = tail;

            head = tail.next;
            tail = tmpNext;
        }

        tail.next = null;
    }

    public void v2(ListNode head) {
        // Reverse the second half in way the lists are disconnected. Will this be
        // faster?
        ListNode turtle = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
        }

        ListNode head2 = reverse(turtle, null);

        while (head.next != null && head2 != null) {
            ListNode tmpNext = head2.next;

            head2.next = head.next;
            head.next = head2;

            head = head2.next;
            head2 = tmpNext;
        }

        head.next = null;
    }

    public void reorderList(ListNode head) {
        v2(head);
    }
}
