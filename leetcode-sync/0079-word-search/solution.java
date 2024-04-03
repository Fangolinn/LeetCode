class Solution {
    // Chat GPT, I wasn't able to come up with my own solution
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        // Iterate through each cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        // If all characters in the word are found
        if (index == word.length())
            return true;
        
        int m = board.length;
        int n = board[0].length;
        
        // Check if i and j are within the bounds of the board
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index))
            return false;
        
        // Mark the cell as visited
        char temp = board[i][j];
        board[i][j] = ' ';
        
        // Explore adjacent cells
        boolean found = dfs(board, i + 1, j, word, index + 1) ||
                        dfs(board, i - 1, j, word, index + 1) ||
                        dfs(board, i, j + 1, word, index + 1) ||
                        dfs(board, i, j - 1, word, index + 1);
        
        // Restore the cell value
        board[i][j] = temp;
        
        return found;
    }
}
