class Solution {

    public static int findMax(int[][] grid, int i, int j) {
        int max = grid[i][j]; 
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                if (grid[k][l] > max) {
                    max = grid[k][l]; 
                }
            }
        }
        return max;
    }


    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int [n-2][n-2];
        for(int i = 0; i < n-2 ; i++){
            for(int j = 0; j < n-2 ; j++){
                res[i][j] = findMax(grid, i , j); 
            }
        }
        return res;
    }
}
