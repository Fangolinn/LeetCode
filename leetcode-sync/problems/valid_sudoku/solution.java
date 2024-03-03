
import java.util.*;

class Solution {
    private boolean doesRepeat(char symbol, Set<Character> alreadyPresent) {
        if (symbol == '.') {
            return false;
        }

        return !alreadyPresent.add(symbol);
    }

    public boolean isValidSudoku(char[][] board) {
        // Can definetely be improved

        // Check rows
        for (int i = 0; i < 9; ++i) {
            Set<Character> alreadyPresent = new HashSet<>();
            for (int j = 0; j < 9; ++j) {
                char symbol = board[i][j];

                if (doesRepeat(symbol, alreadyPresent)) {
                    return false;
                }
            }
        }

        // Check columns
        for (int i = 0; i < 9; ++i) {
            Set<Character> alreadyPresent = new HashSet<>();
            for (int j = 0; j < 9; ++j) {
                char symbol = board[j][i];

                if (doesRepeat(symbol, alreadyPresent)) {
                    return false;
                }
            }
        }

        // Check boxes
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> alreadyPresent = new HashSet<>();
                for (int k = i; k < i + 3; ++k) {
                    for (int l = j; l < j + 3; ++l) {
                        char symbol = board[l][k];

                        if (doesRepeat(symbol, alreadyPresent)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}