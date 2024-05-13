class Solution {
    private void flipRow(int[][] grid, int row) {
        for (int col = 0; col < grid[0].length; col++) {
            grid[row][col] = 1 - grid[row][col];
        }
    }

    // Method to flip a column
    private void flipCol(int[][] grid, int col) {
        for (int row = 0; row < grid.length; row++) {
            grid[row][col] = 1 - grid[row][col];
        }
    }

    // Method to convert a row to a decimal value
    private int checkRow(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result * 2 + num;
        }
        return result;
    }

    public int matrixScore(int[][] grid) {
        int nRows = grid.length, nCols = grid[0].length;

        // Ensuring the first column has all 1s
        for (int row = 0; row < nRows; row++) {
            if (grid[row][0] == 0) {
                flipRow(grid, row);
            }
        }

        // Optimize columns for maximum number of 1s
        for (int col = 1; col < nCols; col++) {
            int countOne = 0;
            for (int row = 0; row < nRows; row++) {
                if (grid[row][col] == 1) {
                    countOne++;
                }
            }
            if (countOne * 2 < nRows) { // More 0s than 1s
                flipCol(grid, col);
            }
        }

        // Calculate the total score
        int totalScore = 0;
        for (int[] row : grid) {
            totalScore += checkRow(row);
        }

        return totalScore;
    }
}