class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxValue = 0 , maxSoFar = 0 , diffMax = 0;
        for (int i = 0; i < nums.length; i++) {
            maxValue = Math.max(maxValue, diffMax * nums[i]);
            diffMax = Math.max(diffMax, maxSoFar - nums[i]);
            maxSoFar = Math.max(maxSoFar, nums[i]);
        }
        return maxValue;
    }
}
