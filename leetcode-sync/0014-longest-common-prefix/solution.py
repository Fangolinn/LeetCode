class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        common_prefix: str = ""

        if len(strs) == 0:
            return ""

        if len(strs) == 1:
            return strs[0]

        for char1, char2 in zip(strs[0], strs[1]):
            if char1 != char2:
                break
            
            common_prefix = common_prefix + char1

        if common_prefix == "":
            return common_prefix

        for string in strs[2:]:
            if len(string) < len(common_prefix):
                common_prefix = common_prefix[:len(string)]

            if common_prefix == "":
                return ""

            for i, (char1, char2) in enumerate(zip(common_prefix, string)):
                if char1 != char2:
                    common_prefix = common_prefix[:i]
                    break

        return common_prefix
        
