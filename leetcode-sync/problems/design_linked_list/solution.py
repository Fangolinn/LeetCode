from ast import List


class ListNode:
    def __init__(self, val=0, next=None):
        self.val: int = val
        self.next: ListNode | None = next

    def __repr__(self) -> str:
        represantation = str(self.val)
        represantation += f" {self.next.__repr__()}" if self.next else ""

        return represantation

class MyLinkedList:

    def __init__(self):
        self._head: ListNode | None = None
        self._len: int = 0
        
    def _get_node(self, index: int) -> ListNode:
        cur: ListNode | None = self._head

        if index < 0: 
            return cur

        for _ in range(index):
            cur = cur.next

        return cur

    def get(self, index: int) -> int:
        if index < 0 or index > self._len - 1:
            return -1
        
        node: ListNode = self._get_node(index)

        return node.val if node else -1

        
    def addAtHead(self, val: int) -> None:
        head_next = self._head if self._head else None
        self._head = ListNode(val, head_next)

        self._len += 1
        # print("Inserted at head,", f"len: {self._len}")
        # print(self)

    def addAtTail(self, val: int) -> None:
        if not self._head:
            self.addAtHead(val)
            return
        
        cur = self._head
        while cur.next:
            cur = cur.next

        cur.next = ListNode(val)

        self._len += 1
        # print("Inserted at tail,", f"len: {self._len}")
        # print(self)

    def addAtIndex(self, index: int, val: int) -> None:
        if index > self._len or index < 0:
            return
        
        if index == 0:
            self.addAtHead(val)
            return

        if index == self._len:
            self.addAtTail(val)
            return

        cur = self._get_node(index - 1)

        tmp_cur_next = cur.next
        cur.next = ListNode(val, tmp_cur_next)

        self._len += 1
        # print(f"Inserted at {index},", f"len: {self._len}")
        # print(self)
        

    def deleteAtIndex(self, index: int) -> None:
        if index > self._len - 1:
            return
        
        if index == 0:
            self._head = self._head.next
            return

        cur = self._get_node(index - 1)

        tmp_cur_next_next = cur.next.next
        del cur.next
        cur.next = tmp_cur_next_next
        
        self._len -= 1
        # print(f"Deleted at {index},", f"len: {self._len}")
        # print(self)

    def __repr__(self) -> str:
        return self._head.__repr__()
    

# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)