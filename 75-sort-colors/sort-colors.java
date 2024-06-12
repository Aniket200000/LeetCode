class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int i = 0;

        while (i <= high) {
            switch (nums[i]) {
                case 0:
                    swap(nums, i++, low++);
                    break;
                case 1:
                    i++;
                    break;
                case 2:
                    swap(nums, i, high--);
                    break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}