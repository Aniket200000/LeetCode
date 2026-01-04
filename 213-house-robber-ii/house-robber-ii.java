class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;
        if( n== 1) return nums[0];

        int money1 = robSimple(nums , 0 , n-2);

        int money2 = robSimple(nums , 1 , n- 1);

        return Math.max(money1 , money2);
    }


    private int robSimple(int[] nums , int start , int end){
        int prev2 = 0 ;
        int prev1 = 0;

        for(int i = start ; i <= end ; i++){
            int curr = Math.max(prev1 , prev2 + nums[i]);

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}