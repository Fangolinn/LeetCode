
from collections import deque

class MyStack:
    def __init__(self) -> None:
        self._q = deque()

    def push(self, x: int) -> None:
        self._q.append(x)

        for _ in range(len(self._q) - 1):
            self._q.append(self._q.popleft())

    def pop(self) -> int:
        return self._q.popleft()
        
    def top(self) -> int:
        return self._q[0]

    def empty(self) -> bool:
        return not bool(len(self._q))
        


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()
