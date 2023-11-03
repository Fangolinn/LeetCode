class ListNode:
    def __init__(self, val: str, prev=None, next=None) -> None:
        self.val: str = val
        self.next: ListNode | None = next
        self.prev: ListNode | None = prev

    

class BrowserHistory:
    def __init__(self, homepage: str) -> None:
        self._head = ListNode(homepage)
        self._current: ListNode = self._head
        
    def visit(self, url: str) -> None:
        self._current.next = ListNode(url, self._current)
        self._current = self._current.next
        
    def back(self, steps: int) -> str:
        for _ in range(steps):
            if not self._current.prev:
                break

            self._current = self._current.prev

        return self._current.val

    def forward(self, steps: int) -> str:
        for _ in range(steps):
            if not self._current.next:
                break

            self._current = self._current.next

        return self._current.val

# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)