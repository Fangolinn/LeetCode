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

    private ListNode v1(ListNode head) {
        // Slow in comparison to other solutions on leetcode, store all values in a hashmap with corresponding node.
        // More suitable for unsorted linked list.
        if (head == null || head.next == null){
            return head;
        }

        Map<Integer, ListNode> valNodeMap = new HashMap<>();

        int minVal = head.val;
        int maxVal = head.val;

        for (ListNode scanner = head; scanner != null; scanner = scanner.next) {
            maxVal = Math.max(scanner.val, maxVal);
            valNodeMap.put(scanner.val, scanner);
        }

        head.next = null;
        ListNode dummy = head;

        for (int i = minVal + 1; i <= maxVal; i++) {
            if (valNodeMap.containsKey(i)) {
                dummy.next = valNodeMap.get(i);
                dummy = dummy.next;
            }
        }

        dummy.next = null;

        return head;
    }
    
    private ListNode v2(ListNode head) {
        // One pass through array, replace 'next' node if val is the same as current one.        
        ListNode scanner = head;
        while (scanner != null && scanner.next != null) {
            if (scanner.next.val == scanner.val) {
                scanner.next = scanner.next.next;
            } else {
                scanner = scanner.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        return v2(head);
    }
}
