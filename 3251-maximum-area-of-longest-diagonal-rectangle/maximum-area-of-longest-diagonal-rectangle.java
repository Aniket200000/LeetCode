class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
       double maxDiagonal = -1.0;
       int maxArea = 0 ;

       for(int[] rectangle : dimensions){
        int length = rectangle[0];
        int width = rectangle[1];
        double diagonal = Math.sqrt(length*length + width*width);
        int area = length * width;

        if(diagonal > maxDiagonal){
            maxDiagonal = diagonal;
            maxArea = area;
        }
        else if(diagonal == maxDiagonal){
            if(area > maxArea) maxArea = area;
        }
       }
       return maxArea;
    }
}