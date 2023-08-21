class Solution:
    def twoSum(self, numbers: list[int], target: int) -> list[int]:
        if target <= 0:
            for i, x in enumerate(numbers):
                for j, y in enumerate(numbers[i + 1:]):
                    if x + y < target:
                        break

                    if x + y == target:
                        return [i + 1, i + j + 2]

        numbers_len = len(numbers)

        if target == 0:
            # Could implement simeoultenaous search from start and end of the list
            for i, x in enumerate(numbers):
                for j, y in enumerate(numbers[i + 1:]):
                    if x + y == target:
                        return [i + 1, i + j + 2]
                    
        numbers.reverse()

        if target >= 0:
            for i, x in enumerate(numbers):
                if x > target:
                    continue

                for j, y in enumerate(numbers[i + 1:]):
                    if x + y == target:
                        return [numbers_len - (i + j + 1), numbers_len - i]

        
