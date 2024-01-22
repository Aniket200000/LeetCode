import java.util.HashSet;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int d = 0;
        int m = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                d = nums[i];
            }
            set.add(nums[i]);
        }
        
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                m = i;
                break;
            }
        }
        
        return new int[]{d, m};
    }
}