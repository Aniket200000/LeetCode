class Solution {
    public int removeElement(int[] nums, int val) {
        int newSize = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if( nums[i] != val){
                nums[newSize] = nums[i];
                newSize++;
            }
          
        }
     return newSize;
    }
}