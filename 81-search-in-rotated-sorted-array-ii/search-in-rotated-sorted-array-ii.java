class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0 , high = nums.length - 1 , mid = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Fix for Time Exceeded
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue; // Skip this iteration to avoid getting stuck
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                }
                 else {
                    low = mid + 1;
                }
            } 
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } 
                else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
