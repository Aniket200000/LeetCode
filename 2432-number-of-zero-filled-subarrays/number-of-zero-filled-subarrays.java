class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0 ;
        long count = 0 ;

        for(int num : nums){
            if( num == 0){
                count++ ;
            }
            else if( count > 0){
                result += (long) count * (count + 1) / 2;
                count = 0 ;
            }
        }
        if( count > 0){
                result += (long) count * (count + 1) / 2;
                count = 0 ;
        }
        return result;
    }
}