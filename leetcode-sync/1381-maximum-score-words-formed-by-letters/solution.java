import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        Map<String, Integer> wordScores = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int wordScore = 0;

            for (int c : word.toCharArray())
                wordScore += score[c - 97];

            wordScores.put(word, wordScore);
        }

        List<Character> lettersList = new ArrayList<>();

        for (char c : letters)
            lettersList.add(c);

        return getMaxScore(words, 0, wordScores, lettersList, 0);
    }

    private List<Character> canFormWord(List<Character> letters, String word) {
        List<Character> lettersCopy = new ArrayList<>(letters);

        for (Character character : word.toCharArray()) {
            if (!lettersCopy.remove(character))
                return letters;
        }

        return lettersCopy;
    }

    private int getMaxScore(String[] words, int wordIndex, Map<String, Integer> wordsScore, List<Character> letters,
            int currentScore) {
        if (letters.isEmpty())
            return currentScore;

            int maxScore = currentScore;

        for (int i = wordIndex; i < words.length; i++) {
            String word = words[i];
            List<Character> newLetters = canFormWord(letters, word);

            if (newLetters.size() == letters.size())
                continue;

            maxScore = Math.max(maxScore,
                    getMaxScore(words, i + 1, wordsScore, newLetters, currentScore + wordsScore.get(word)));
        }

        return maxScore;
    }
}
