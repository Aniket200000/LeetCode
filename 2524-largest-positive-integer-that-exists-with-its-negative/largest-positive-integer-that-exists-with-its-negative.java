class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);

        // Create a HashSet to store all elements in nums
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }

        // Loop from the end to find the largest positive number with its negative in the set
        for (int i = nums.length - 1; i >= 0; i--) {
            int currentNum = nums[i];
            if (currentNum > 0 && hs.contains(-currentNum)) {
                // Return the positive number if its negative counterpart exists
                return currentNum;
            }
        }

        // If no such number exists, return -1
        return -1;
    }
}