class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((a,b) -> b.getValue() - a.getValue());

        int[] result = new int[k];
        for(int i = 0 ; i < k ; i++){
            result[i] = entryList.get(i).getKey();
        }
        return result;
    }
}