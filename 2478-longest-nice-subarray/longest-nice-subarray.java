class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, bitmask = 0, max = 1;

        for (int right = 0; right < nums.length; right++) {
        
            while ((bitmask & nums[right]) != 0) {
                bitmask ^= nums[left];
                left++;
            }
            bitmask |= nums[right]; 
            max = Math.max(max, right - left + 1); 
        }

        return max;
    }
}