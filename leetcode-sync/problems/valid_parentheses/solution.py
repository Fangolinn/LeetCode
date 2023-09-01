from collections import deque


class Solution:
    def isValid(self, s: str) -> bool:
        stack: deque = deque()

        brackets = {
            "[": "]",
            "(": ")",
            "{": "}"
        }

        opening_brackets = "({["

        for char in s:
            if char in opening_brackets:
                stack.append(char)
                continue

            try:
                if char != brackets[stack.pop()]:
                    return False
            except IndexError:
                return False
            
        return not len(stack)
        
        