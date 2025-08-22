class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        for(int i = 0 ; i < cols ; i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i = 0 ; i < rows ; i++){
            dp[i][0] = matrix[i][0];
        }

        for(int i = 1 ; i < rows ; i++){
            for(int j = 1 ; j < cols ; j++){
                if(matrix[i][j] == 1){
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1] , dp[i-1][j]) , dp[i-1][j-1]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

        int count = 0 ;

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                count += dp[i][j];
            }
        }
        return count;
    }
}