class Solution:
    def sortColors(self, nums: list[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i: int = 0

        for current_num in (0, 1):
            j: int = len(nums) - 1

            while i <= j:
                if nums[i] == current_num:
                    i += 1
                    continue

                if nums[j] == current_num:
                    nums[i], nums[j] = nums[j], nums[i]
                    i += 1

                j -=1


