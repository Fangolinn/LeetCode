from math import sqrt


class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n <= 0:
            return False

        if n == 1:
            return True

        while not n % 1:
            if n == 2:
                return True
            
            n = n / 2

            
        return False
        

        