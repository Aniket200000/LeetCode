class Solution {
    public List<Integer> partitionLabels(String s) {
         Map<Character, Integer> lastIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndexMap.put(s.charAt(i), i);
        }

        List<Integer> partitions = new ArrayList<>();
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndexMap.get(s.charAt(i))); 
            if (i == end) { 
                partitions.add(end - start + 1);
                start = i + 1; 
            }
        }

        return partitions;
    }
}