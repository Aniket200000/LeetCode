class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0 ;
        for(int num : nums) total += num;

        if((total + target) % 2 != 0 || Math.abs(target) > total){
            return 0;
        }

        int subsetSum = (target + total) / 2;

        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;

        for(int num : nums){
            for(int j = subsetSum ; j >= num ; j--){
                dp[j] += dp[j - num];
            }
        }
        return dp[subsetSum];
    }
}