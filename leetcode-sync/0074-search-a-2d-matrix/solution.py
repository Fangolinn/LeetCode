from math import floor


class Solution:
    # def check_rows(self, matrix: list[list[int]], target: int) -> list[int] | False:
    #     left_limit: int = 0
    #     right_limit: int = len(matrix) - 1


    #     while left_limit <= right_limit:
    #         middle: int = floor((left_limit + right_limit) / 2)

    #         val_at_pos: int = nums[middle]

    #         if val_at_pos == target:
    #             return middle
            
    #         if val_at_pos < target:
    #             left_limit = middle + 1
    #             continue

    #         right_limit = middle - 1

    #     return False

    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        for row in matrix:
            left_limit: int = 0
            right_limit: int = len(row) - 1


            while left_limit <= right_limit:
                middle: int = floor((left_limit + right_limit) / 2)

                val_at_pos: int = row[middle]

                if val_at_pos == target:
                    return True
                
                if val_at_pos < target:
                    left_limit = middle + 1
                    continue

                right_limit = middle - 1

        return False
        
