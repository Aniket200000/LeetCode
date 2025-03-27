class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        
        int majorityElement = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                majorityElement = num;
            }
            count += (num == majorityElement) ? 1 : -1;
        }

        int totalCount = 0;
        for (int num : nums) {
            if (num == majorityElement) {
                totalCount++;
            }
        }

        int leftCount = 0, rightCount = totalCount;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == majorityElement) {
                leftCount++;
                rightCount--;
            }

            if (leftCount * 2 > (i + 1) && rightCount * 2 > (n - i - 1)) {
                return i;
            }
        }

        return -1;  
    }
}
