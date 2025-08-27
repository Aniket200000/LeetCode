class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0 ;
        int right = height.length-1;

        while(left < right){
            int width = right - left ;
            int area = Math.min(height[left],height[right]) * width;
            maxWater = Math.max(maxWater , area);

            if(height[left]>height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return maxWater;
    }
}