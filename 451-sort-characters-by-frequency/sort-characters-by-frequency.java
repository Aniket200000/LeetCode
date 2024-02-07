class Solution {
    public String frequencySort(String s) {
        StringBuilder answer = new StringBuilder();
        Map<Character , Integer> hashmap = new HashMap<>();
        for(char ch : s.toCharArray()){
            hashmap.put(ch , hashmap.getOrDefault(ch, 0) + 1);
        }
        List<Character> list = new ArrayList(hashmap.keySet());
        list.sort((obj1 , obj2)  -> hashmap.get(obj2) - hashmap.get(obj1));
        for(char ch : list){
            for(int i = 0 ; i < hashmap.get(ch); i++){
                answer.append(ch);
            }
        }
        return  answer.toString() ;
    }
}