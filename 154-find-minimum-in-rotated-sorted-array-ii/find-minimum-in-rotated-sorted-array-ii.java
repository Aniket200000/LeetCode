class Solution {
    public int findMin(int[] nums) {
        int low = 0 , high = nums.length-1 , mid = 0;

        while (low < high){
            mid = low + (high - low)/2;

            if(nums[mid] > nums[high]){
                low = mid + 1;
            }

            else if(nums[mid] < nums[high]){
                high = mid;
            }
            else{
                high = high - 1;
            }
        }
        return nums[low];
        
    }
}