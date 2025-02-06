class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
       int n = matrix[0].length;

       int low = 0 , high = m*n-1 , mid = 0;

       while(low <= high){
        mid = low + (high-low)/2;
        int midValue = matrix[mid / n][mid % n];

        if(midValue == target){
            return true;
        }
        else if(midValue < target){
            low = mid + 1;
        }
        else{
            high = mid -1;
        }
       }
       return false;
    }
}