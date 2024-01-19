class Solution {
    public int minFallingPathSum(int[][] A) {
          if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }

        int rows = A.length;
        int cols = A[0].length;

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                A[i][j] += Math.min(
                        A[i - 1][j],
                        Math.min(
                                j > 0 ? A[i - 1][j - 1] : Integer.MAX_VALUE,
                                j < cols - 1 ? A[i - 1][j + 1] : Integer.MAX_VALUE
                        )
                );
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < cols; j++) {
            minSum = Math.min(minSum, A[rows - 1][j]);
        }

        return minSum;
    }
}