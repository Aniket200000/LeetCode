class Solution {
    public int firstStableIndex(int[] nums, int k) {
        for(int i = 0 ; i < nums.length ; i++){
            int leftMax = nums[0];

            for(int j = 0 ; j <= i ; j++){
                leftMax = Math.max(leftMax , nums[j]);
            }

            int rightMin = nums[i];

            for(int j = i ; j < nums.length ; j++){
                rightMin = Math.min(rightMin , nums[j]);
            }

            if(leftMax - rightMin <= k)
            return i;
        }
        return -1;
    }
    
}