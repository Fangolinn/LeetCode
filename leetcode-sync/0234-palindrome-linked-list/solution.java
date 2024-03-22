import java.util.ArrayList;
import java.util.List;

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
    //     int val;
    //     ListNode next;

    //     ListNode() {
    //     }

    //     ListNode(int val) {
    //         this.val = val;
    //     }

    //     ListNode(int val, ListNode next) {
    //         this.val = val;
    //         this.next = next;
    //     }
    // }

    public boolean v1(ListNode head) {
        // Very simplistic solution, insert all values into a List and check it against
        // itself reversed

        List<Integer> values = new ArrayList<>();

        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        return values.equals(values.reversed());
    }

    public boolean v2(ListNode head) {
        // Attempt at a bit smarter solution
        // Use 'turtle' and 'hare' pointers to respectively find the end and middle of
        // the list (turtle moves by one list item per loop iteration, hare by two)
        // Insert values seen by turtle into a list, once hare reaches the end start
        // comparing in reverse order

        ListNode turtle = head;
        ListNode hare = head;

        List<Integer> values = new ArrayList<>();

        while (hare != null && hare.next != null) {
            values.add(turtle.val);
            turtle = turtle.next;
            hare = hare.next.next;
        }

        // List has an odd length, skip middle element
        if (hare != null) {
            turtle = turtle.next;
        }

        int i = values.size() - 1;
        for (; i >= 0 && turtle != null; i--, turtle = turtle.next) {
            if (turtle.val != values.get(i)) {
                return false;
            }
        }

        return !(i >= 0 || turtle != null);
    }

    public boolean v3(ListNode head) {
        ListNode turtle = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
        }

        // Reverse the second half
        ListNode prevNode = turtle;

        while (turtle != null) {
            ListNode oldNext = turtle.next;
            turtle.next = prevNode;
            prevNode = turtle;
            turtle = oldNext;
        }

        for (ListNode tail = prevNode; head != tail && head != tail.next; head = head.next, tail = tail.next) {
            if (head.val != tail.val) {
                return false;
            }
        }

        return true;

    }

    public boolean isPalindrome(ListNode head) {
        return v3(head);
    }
}
