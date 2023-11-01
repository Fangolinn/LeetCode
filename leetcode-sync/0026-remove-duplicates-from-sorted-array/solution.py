class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        # current_last_sorted_element: int = 0

        # for num in nums[1:]:
        #     if num != nums[current_last_sorted_element]:
        #         current_last_sorted_element += 1
        #         nums[current_last_sorted_element] = num

        # return current_last_sorted_element + 1

        nums_deduplicated = sorted(list(set(nums)))

        nums[0:] = nums_deduplicated
        return len(nums_deduplicated)


            
        
