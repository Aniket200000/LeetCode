import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int majorityElement = -1, maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                majorityElement = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        int leftCount = 0, rightCount = maxCount;
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
