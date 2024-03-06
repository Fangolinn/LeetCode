/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
import java.util.HashSet;
import java.util.Set;

public class Solution {
    // class ListNode {
    //     int val;
    //     ListNode next;

    //     ListNode(int x) {
    //         val = x;
    //         next = null;
    //     }
    // }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> previousNodes = new HashSet<>();

        if (head == null || head.next == null) {
            return false;
        }

        ListNode tortoise = head;
        ListNode hare = head.next;

        while (hare != null && hare.next != null) {
            if (tortoise == hare) {
                return true;
            }

            tortoise = tortoise.next;
            hare = hare.next.next;
        }

        return false;
    }
}
