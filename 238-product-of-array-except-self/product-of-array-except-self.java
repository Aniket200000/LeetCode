class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int pre = 1 , post = 1;
        for(int i = 0 ; i<nums.length ; i++){
            result[i] = pre;
            pre = nums[i] * pre;
        }

        for(int i = nums.length-1 ; i >= 0 ; i--){
            result[i] = post*result[i];
            post = nums[i]*post;
        }
        return result;
    }
}