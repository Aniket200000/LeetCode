class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length ;
        int expectedAnswer = n * (n + 1)/2 ;
        int actualAnswer = 0 ;

        for(int i = 0 ; i < nums.length ; i++){
            actualAnswer = actualAnswer + nums[i] ;
        }

        int missingNumber = expectedAnswer - actualAnswer ;

        return missingNumber ;
    }
}