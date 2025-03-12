class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        map.put('a',0);
        map.put('b',0);
        map.put('c',0);

        int left = 0 , count = 0;

        //expanding the window
        for ( int right = 0 ; right < s.length() ; right++){
            map.put(s.charAt(right),map.get(s.charAt(right))+1);

            // checking if window is valid
            while(map.get('a') > 0 && map.get('b') > 0 && map.get('c') > 0){
                //ading all valid strins to count
                count += s.length() - right ;

                map.put(s.charAt(left),map.get(s.charAt(left))-1); // Reduce freq from map
                left++;
            }
        }
        return count;
    }
}