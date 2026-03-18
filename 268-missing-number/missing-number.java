class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        int count=nums.length;
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
        }
        int totalSum= count*(count+1)/2;

        return totalSum- sum;
    }
}