class Solution:
    def fib(self, n: int) -> int:
        if n == 0:
            return 0
        
        if n == 1:
            return 1
        
        prev, current = 0, 1

        for _ in range(n - 1):
            prev, current = current, prev + current

        return current
  
