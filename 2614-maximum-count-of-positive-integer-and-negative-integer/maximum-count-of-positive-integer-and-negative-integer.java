class Solution {
    public int maximumCount(int[] nums) {
        int negativeNo = 0;
        int positiveNo = 0;
        for(int i = 0 ; i< nums.length ;i++){
            if(nums[i] < 0){
            negativeNo += 1 ;
            }

           else if(nums[i] > 0){
            positiveNo += 1 ;
            }
        }
        return Math.max(positiveNo, negativeNo);
    }
}