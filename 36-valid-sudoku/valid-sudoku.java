class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> box = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                
                if (board[i][j] != '.' && !row.add(board[i][j]))
                return false;
                
                if (board[j][i] != '.' && !col.add(board[j][i]))
                return false;
                
                int rowIdx = 3 * (i / 3) + j / 3;
                int colIdx = 3 * (i % 3) + j % 3;
                if (board[rowIdx][colIdx] != '.' && !box.add(board[rowIdx][colIdx]))
                return false;
            }
        }
        return true;
    }
}
