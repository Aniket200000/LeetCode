class Solution {
    public int maxArea(int[] height) {
        int n = height.length - 1;
        int left = 0;
        int right = n;
        int maxWater = 0;

        while(left < right){
            int width = right - left;
            int area = Math.min(height[left],height[right]) * width;
            maxWater = Math.max(area , maxWater);

            if(height[left]>height[right])right--;
            else left++;
        }
        return maxWater;
    }
}