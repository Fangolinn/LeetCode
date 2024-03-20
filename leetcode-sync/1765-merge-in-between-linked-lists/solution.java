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

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode leftCutBoundary = list1;

        for (int i = 0; i < a - 1; i++) {
            leftCutBoundary = leftCutBoundary.next;
        }

        ListNode rightCutBoundary = leftCutBoundary;

        for (int i = a - 1; i <= b; i++) {
            rightCutBoundary = rightCutBoundary.next;
        }

        ListNode list2Tail = list2;

        while (list2Tail.next != null) {
            list2Tail = list2Tail.next;
        }

        leftCutBoundary.next = list2;
        list2Tail.next = rightCutBoundary;

        return list1;
    }
}
