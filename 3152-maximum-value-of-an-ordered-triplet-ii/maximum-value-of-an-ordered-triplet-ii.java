class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxValue = 0 , maxSoFar = 0 , diffMax = 0;
        for (int num : nums ){

            maxValue = Math.max(maxValue, diffMax * num);

            diffMax = Math.max(diffMax, maxSoFar - num);
            
            maxSoFar = Math.max(maxSoFar, num);
        }
        return maxValue;
    }
}
