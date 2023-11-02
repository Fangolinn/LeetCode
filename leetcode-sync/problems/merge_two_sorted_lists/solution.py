# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val: int = val
        self.next: ListNode | None = next

    def __repr__(self) -> str:
        represantation = str(self.val)
        represantation += f" {self.next.__repr__()}" if self.next else ""

        return represantation

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1 or not list2:
            return list1 if list1 else list2
        
        if list2.val < list1.val:
            list1, list2 = list2, list1

        list1_head = list1
        
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
    
# if __name__ == "__main__":
#     nodes = [ListNode(val=x) for x in [1, 1, 2, 3, 4, 4]]
#     list1 = nodes[0]
#     list1.next = nodes[2]
#     list1.next.next = nodes[4]

#     list2 = nodes[1]
#     list2.next = nodes[3]
#     list2.next.next = nodes[5]

#     solution = Solution()
#     print(solution.mergeTwoLists(list1, list2))


     
        