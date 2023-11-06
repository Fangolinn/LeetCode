class Solution:
    def insertion_sort(self, nums: list[int]) -> list[int]:
        for index in range(1, len(nums)):
            pos: int = index

            while pos:
                if nums[pos - 1] > nums[index]:
                    pos -= 1
                    continue

                break

            if pos != index:
                nums.insert(pos, nums.pop(index))

        return nums

    def merge_sort(self, nums: list[int]) -> list[int]:
        if len(nums) == 1:
            return nums

        nums_len_half = int(len(nums) / 2)

        arr_sorted1, arr_sorted2 = self.merge_sort(
            nums[0:nums_len_half]
        ), self.merge_sort(nums[nums_len_half:])

        # print(arr_sorted1, arr_sorted2)

        result_arr = []

        i = 0
        j = 0

        while i < len(arr_sorted1) and j < len(arr_sorted2):
            if arr_sorted1[i] > arr_sorted2[j]:
                result_arr.append(arr_sorted2[j])
                j += 1
                continue

            result_arr.append(arr_sorted1[i])
            i += 1

        if i < len(arr_sorted1):
            result_arr.extend(arr_sorted1[i:])

        if j < len(arr_sorted2):
            result_arr.extend(arr_sorted2[j:])

        # print(result_arr)

        return result_arr

    def sortArray(self, nums: list[int]) -> list[int]:
        return self.merge_sort(nums)
    
if __name__ == "__main__":
    test_arr = [5, 1, 1, 2, 0, 0]

    solution = Solution()

    print(solution.sortArray(test_arr))
