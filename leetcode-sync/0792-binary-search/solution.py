from math import floor

class Solution:
    def search(self, nums: list[int], target: int) -> int:
        left_limit: int = 0
        right_limit: int = len(nums) - 1


        while left_limit <= right_limit:
            middle: int = floor((left_limit + right_limit) / 2)

            val_at_pos: int = nums[middle]

            if val_at_pos == target:
                return middle
            
            if val_at_pos < target:
                left_limit = middle + 1
                continue

            right_limit = middle - 1

        return -1
        
