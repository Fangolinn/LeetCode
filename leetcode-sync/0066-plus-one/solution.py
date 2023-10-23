class Solution:
    def plusOne(self, digits: list[int]) -> list[int]:
        for i in range(1, len(digits) + 1):
            temp = digits[-i] + 1
            digits[-i] = temp if temp != 10 else 0

            if temp != 10:
                break

        if temp == 10:
            digits.insert(0, 1)

        return digits

        
