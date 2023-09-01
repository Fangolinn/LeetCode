from collections import deque
from string import digits

class Solution:
    def evalRPN(self, tokens: list[str]) -> int:
        stack: deque[int] = deque()

        for token in tokens:
            match token:
                case "+":
                    a, b = stack.pop(), stack.pop()
                    stack.append(a + b)
                case "-":
                    b, a = stack.pop(), stack.pop()
                    stack.append(a - b)
                case "*":
                    a, b = stack.pop(), stack.pop()
                    stack.append(a * b)
                case "/":
                    b, a = stack.pop(), stack.pop()
                    stack.append(int(a / b))
                case _:
                    stack.append(int(token))
                
        return stack.pop()

            
        