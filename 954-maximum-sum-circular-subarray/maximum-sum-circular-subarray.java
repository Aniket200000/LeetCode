class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(sum + nums[i] > nums[i]){
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            if(sum > maxSum){
                maxSum = sum;
            }
        }

        int sub = nums[0];
        int maxSub = nums[0];
        int total = nums[0];
        for(int i = 1; i < nums.length; i++){
            total += nums[i];
            if(sub + nums[i] < nums[i]){
                sub += nums[i];
            } else {
                sub = nums[i];
            }
            if(sub < maxSub){
                maxSub = sub;
            }
        }

        if(maxSum < 0) return maxSum;
        return Math.max(maxSum, total - maxSub);
    }
}
