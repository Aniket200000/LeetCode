class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        
        int i = 0, j = 0, flag = 1;  
        for (int k = 0; k < m * n; k++) {
            result[k] = mat[i][j];
            if(flag == 1){
                if(i==0 && j!=n-1){
                    j++;
                    flag = 0;
                }
                else if(j==n-1){
                    i++;
                    flag=0;
                }
                else{
                    i--;
                    j++;
                }
            }
            else{
                if(j==0 && i!=m-1){
                    i++;
                    flag = 1;
                }
                else if(i==m-1){
                    j++;
                    flag=1;
                }
                else{
                    i++;
                    j--;
                }
            }
        }
        return result;
    }
}
