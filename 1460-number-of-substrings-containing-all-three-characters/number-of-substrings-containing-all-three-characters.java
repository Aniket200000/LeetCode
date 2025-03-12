class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character , Integer > map = new HashMap<>();
        map.put('a' , 0);
        map.put('b' , 0);
        map.put('c' , 0);

        int count = 0;
        int left = 0;

        for( int right = 0 ; right < s.length() ; right++){
            map.put(s.charAt(right) , map.get(s.charAt(right)) + 1);

            while(map.get('a') > 0 && map.get('b') > 0 && map.get('c') > 0){
                count += s.length() - right;

                map.put(s.charAt(left) , map.get(s.charAt(left)) - 1);
                left++;
            }
        }
        return count;
    }
}