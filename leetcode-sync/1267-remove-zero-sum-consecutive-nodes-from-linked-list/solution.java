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
import java.util.*;

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

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;

        // Traverse the linked list and store the running sum
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            sum += curr.val;
            map.put(sum, curr);
        }

        // Traverse again and remove the zero-sum subsequences
        sum = 0;
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            sum += curr.val;
            curr.next = map.get(sum).next;
        }

        return dummy.next;
    }
}
