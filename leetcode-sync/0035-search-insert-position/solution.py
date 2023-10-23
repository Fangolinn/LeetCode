class Solution:
    def searchInsert(self, nums: list[int], target: int) -> int:
        element_index = 0
        
        for num in nums:
            if num >= target:
                return element_index
            
            element_index += 1

        return element_index
        
