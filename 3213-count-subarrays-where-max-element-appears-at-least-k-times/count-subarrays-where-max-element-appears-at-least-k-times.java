class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        //max element
        int maxNum = Integer.MIN_VALUE;
        for(int i=0 ; i < n ; i++){
            maxNum = Math.max(maxNum , nums[i]);
        }

        long countOfSubarrays = 0;
      
        // Initialize the count of maximum number in the current window
        int maxCount = 0;
      
        // Initialize the right pointer for the window to 0
        int rightPointer = 0;
      
        // Iterate over each element in the nums array with index represented by leftPointer
        for (int leftPointer = 0; leftPointer < n; leftPointer++) {
            // Expand the window until we have less than k occurrences of the maximum number
            while (rightPointer < n && maxCount < k) {
                // Increase the count if the current number is the maximum number
                if (nums[rightPointer] == maxNum) {
                    maxCount++;
                }
                // Move the right pointer to the right
                rightPointer++;
            }
          
            // If we have found k or more occurrences, we cannot form more subarrays, so we break out
            if (maxCount < k) {
                break;
            }
          
            // Update the count of subarrays with the number of ways to choose the end point of subarrays
            countOfSubarrays += n - rightPointer + 1;
          
            // Exclude the current left pointer number from count if it's the maximum number
            if (nums[leftPointer] == maxNum) {
                maxCount--;
            }
        }
      
        // Return the total number of subarrays
        return countOfSubarrays;
        
    }
}