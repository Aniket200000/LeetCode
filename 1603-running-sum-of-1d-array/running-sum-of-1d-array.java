class Solution {
    public int[] runningSum(int[] nums) {
        int result[] = new int[nums.length];
        result[0] = nums[0];
        int a = nums[0] ;
        for(int i = 1 ; i < nums.length ; i++){
            result[i] = a + nums[i];
            a =  result[i];
        }
        return result;
    }
}