# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

from math import floor

class Solution:
    def firstBadVersion(self, n: int) -> int:
        # binary search
        left_limit: int = 1
        right_limit: int = n

        while left_limit <= right_limit:
            middle: int = floor((left_limit + right_limit) / 2)

            if not isBadVersion(middle):
                left_limit = middle + 1
                continue

            if not isBadVersion(middle - 1):
                break

            right_limit = middle - 1

        return middle
    
