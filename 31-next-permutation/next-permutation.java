class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length - 1;

        for (int i = n; i > 0; i--) {  
            if (nums[i] > nums[i - 1]) {
                for (int j = n; j >= i; j--) {  
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, j, i - 1);
                        break;
                    }
                }
                reverse(nums, i, n);  
                return;
            }
        }
        reverse(nums, 0, n);  
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
