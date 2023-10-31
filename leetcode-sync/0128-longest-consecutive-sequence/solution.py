import copy


class Solution:
    def longestConsecutive(self, nums: list[int]) -> int:
        if len(nums) in (0, 1):
            return len(nums)

        nums_set: set[int] = set(nums)

        item: int = nums_set.pop()
        current_sequence_edges: list[int] = [item, item]
        del item

        len_current_sequence: int = 1
        len_longest_sequence: int = 0

        while len(nums_set):
            if (checked_value := current_sequence_edges[-1] + 1) in nums_set:
                nums_set.discard(checked_value)
                current_sequence_edges[-1] = checked_value
                len_current_sequence += 1
                continue

            if (checked_value := current_sequence_edges[0] - 1) in nums_set:
                nums_set.discard(checked_value)
                current_sequence_edges[0] = checked_value
                len_current_sequence += 1
                continue

            if len_current_sequence > len_longest_sequence:
                len_longest_sequence = len_current_sequence
            
            item = nums_set.pop()
            current_sequence_edges: list[int] = [item, item]
            del item

            len_current_sequence = 1

        return len_longest_sequence if len_longest_sequence > len_current_sequence else len_current_sequence

if __name__ == "__main__":
    solution_cls = Solution()

    print(solution_cls.longestConsecutive([0,3,7,2,5,8,4,6,0,1]))
        
