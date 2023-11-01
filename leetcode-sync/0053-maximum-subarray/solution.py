class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        max_sum: int = nums[0]
        current_sum: int = 0

        for num in nums:
            current_sum = max(0, current_sum)
            current_sum += num
            max_sum = max(current_sum, max_sum)

        return max_sum
  
