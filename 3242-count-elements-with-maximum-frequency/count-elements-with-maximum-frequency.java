class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int val : nums) {
            map.put(val, map.getOrDefault(val, 0)+1);
        }

        int count = 0;
        int max = -1;
        for(int freq : map.values()) {
            max = Math.max(max, freq);
        }

        for(int freq : map.values()) {
            if(freq==max) {
                count += max;
            }
        }
        return count;
    }
}