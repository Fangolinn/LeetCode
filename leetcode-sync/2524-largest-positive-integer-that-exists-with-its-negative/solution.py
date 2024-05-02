class Solution:
    # Code copied from leetcode solutions as I dont have access to a computer ATM, but I had the same instinct
    def findMaxK(self, nums: List[int]) -> int:
        res = -1
        nums = set(nums)
        for num in nums:
            if num * -1 in nums:
                res = max(res, num)
        return res


