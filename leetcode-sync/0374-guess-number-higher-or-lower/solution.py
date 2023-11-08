# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0
# def guess(num: int) -> int:

from math import floor

class Solution:
    def guessNumber(self, n: int) -> int:
        left_limit: int = 1
        right_limit: int = n

        middle: int = floor((left_limit + right_limit) / 2)

        while result := guess(middle):
            if result == 1:
                left_limit = middle + 1
            elif result == -1:
                right_limit = middle - 1

            middle: int = floor((left_limit + right_limit) / 2)

        return middle
        
