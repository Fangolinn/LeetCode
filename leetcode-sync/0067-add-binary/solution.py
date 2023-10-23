class Solution:
    def addBinary(self, a: str, b: str) -> str:
        if len(b) < len(a):
            a, b = b, a

        if len(a) < len(b):
            a = ((len(b) - len(a)) * "0") + a

        result: str = ""
        carryover = 0

        for a_bit, b_bit in zip(reversed(a), reversed(b)):
            a_bit, b_bit = int(a_bit), int(b_bit)

            match (a_bit + b_bit + carryover):
                case 0:
                    result += "0"
                case 1:
                    result += "1"
                    carryover = 0
                case 2:
                    result += "0"
                    carryover = 1
                case 3:
                    result += "1"

        if carryover:
            result += "1"

        return result[::-1] if result else "0"
    
# if __name__ == "__main__":
#     solution = Solution()

#     print(solution.addBinary("1010", "1011"))

        
