class Solution {
    public boolean makeEqual(String[] words) {
        int[] charCount = new int[26];

        for (String s : words) {
            for (char c : s.toCharArray()) {
                charCount[c - 'a']++;
            }
        }

        for (int count : charCount) {
            if (count % words.length != 0)
                return false;
        }

        return true;
    }
}
