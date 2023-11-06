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
    def mergeTwoLists(self, list1: ListNode | None, list2: ListNode | None) -> ListNode:
        if not list1 or not list2:
            return list1 if list1 else list2

        if list2.val < list1.val:
            list1, list2 = list2, list1

        list1_head: ListNode = list1
        
        while list2:
            if not list1.next:
                list1.next = list2
                break

            if list1.next.val <= list2.val:
                list1 = list1.next
                continue

            next_list2 = list2.next
            list2.next = list1.next
            list1.next = list2
            list2 = next_list2

            list1 = list1.next

        return list1_head

    def mergeKLists(self, lists: list[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        
        if len(lists) == 1:
            return lists[0]
        
        no_of_lists_halved = int(len(lists) / 2)

        list1: ListNode = self.mergeKLists(lists[:no_of_lists_halved])
        list2: ListNode = self.mergeKLists(lists[no_of_lists_halved:])

        return self.mergeTwoLists(list1, list2)


        