/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int listLength = 0;

        ListNode scanner = head;

        while (scanner != null){
            listLength++;
            scanner = scanner.next;
        }

        for (int i = 0; i < Math.floor(listLength / 2); i++){
            head = head.next;
        }

        return head;
    }
}
