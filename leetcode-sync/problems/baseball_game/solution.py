class Solution:
    def calPoints(self, operations: list[str]) -> int:
        scores: list[int] = []

        for operation in operations:
            match operation:
                case '+':
                    scores.append(scores[-2] + scores[-1])
                case 'D':
                    scores.append(scores[-1] * 2)
                case 'C':
                    scores.pop()
                case _:
                    scores.append(int(operation))
        
        return sum(scores)
        