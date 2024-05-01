class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        try:
            ch_index = word.index(ch) +1
            prefix = word[:ch_index][::-1]
            return prefix + word[ch_index:]
        except:
            return word

