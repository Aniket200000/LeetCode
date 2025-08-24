class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int count1 = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count1++;
            } else {
                list.add(count1);
                count1 = 0;
            }
        }
        list.add(count1);

        if (list.size() == 1) {
            return list.get(0) - 1;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            max = Math.max(max, list.get(i) + list.get(i + 1));
        }
        return max;
    }
}
