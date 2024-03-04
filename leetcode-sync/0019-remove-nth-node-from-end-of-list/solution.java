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
    // This needs to be commented when submitting!!!
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode scanner = head;

        int scannerAheadBy = 0;
        do {
            scanner = scanner.next;
            scannerAheadBy++;
        } while (scannerAheadBy < n);

        if (scanner == null) {
            return head.next;
        }

        ListNode beforeRemoved = head;

        while (scanner.next != null) {
            scanner = scanner.next;

            beforeRemoved = beforeRemoved.next;
        }

        beforeRemoved.next = beforeRemoved.next.next;

        return head;
    }
}
