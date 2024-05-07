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

    public ListNode doubleIt(ListNode head) {
        head = reverseLinkedList(head);

        int carry = 0;
        ListNode currentNode = head;

        while (currentNode != null){
            int newVal = currentNode.val * 2 + carry;
            currentNode.val = newVal % 10;
            carry = newVal / 10;

            currentNode = currentNode.next;
        }

        head = reverseLinkedList(head);

        if (carry == 1){
            head = new ListNode(1, head);
        }

        return head;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode currentNode = head;
        ListNode prevNode = null;

        while (currentNode != null) {
            ListNode oldNext = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = oldNext;
        }

        return prevNode;
    }
}
