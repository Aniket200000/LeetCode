class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int prod = 1;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0) zeroCount++;
            else prod *= nums[i];
        }

        int[] result = new int[nums.length];
        for(int i = 0 ; i < nums.length ;i++){
             if(zeroCount > 1){
            result[i] = 0;
            }
            else if(zeroCount == 1){
                result[i] = (nums[i] == 0) ? prod : 0;
            }
            else{
                result[i] = prod/nums[i];
            }
        }
       return result;
    }
}