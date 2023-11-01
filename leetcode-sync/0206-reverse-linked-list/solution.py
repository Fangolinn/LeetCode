# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head: return head
        
        prev: ListNode | None = None
        curr_node: ListNode = head

        while True:
            next: ListNode | None = curr_node.next
            curr_node.next, prev = prev, curr_node
            if not next:
                break
            curr_node = next

        return curr_node


        
