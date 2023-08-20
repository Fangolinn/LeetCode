class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        groups = []

        for word in reversed(strs):
            is_grouped = False
            word_sorted = sorted(word)
            for group in groups:
                if word_sorted == group[0]:
                    group.append(word)
                    is_grouped = True
                    break

            if is_grouped:
                continue

            groups.append([word_sorted, word])

        for group in groups:
            group.pop(0)

        return groups
        
