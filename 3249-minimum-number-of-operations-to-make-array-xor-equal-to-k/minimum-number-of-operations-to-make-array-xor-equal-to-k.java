class Solution {
    public int minOperations(int[] nums, int k) {
        int finalXor = 0;
        for(int i = 0; i<nums.length ; i++){
            finalXor = finalXor ^ nums[i];
        }
        int res = finalXor ^ k;
        int count = 0;
        // find the different bits in finalXor & k

        while(res > 0){
            if(res % 2 == 1){
            count++;
            }
            res = res / 2 ;
        }
        return count ;
    }
}