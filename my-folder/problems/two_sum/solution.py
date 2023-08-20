class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        for i, x in enumerate(nums[:-1]):
            for j, y in enumerate(nums[i + 1:]):
                if x + y == target:
                    return [i, i + j + 1]
        