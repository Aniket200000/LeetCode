class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int max = -1, count = 0;

        for (int num : nums) {
            if (count == 0)
                max = num;
            count += (num == max) ? 1 : -1;
        }

        int totalCount = 0;
        for (int num : nums) {
            if (num == max)
                totalCount++;
        }

        int left = 0, right = totalCount;

        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == max) {
                left++;
                right--;
            }

            if (left * 2 > (i + 1) && right * 2 > (n - i - 1)) {
                return i;
            }
        }
        return -1;
    }
}