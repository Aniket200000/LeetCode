class Solution {
    public int longestPalindrome(String s) {
        int length = 0;
        HashSet<Character> hs = new HashSet<>();
        
        for (int idx = 0; idx < s.length(); idx++) {
            char character = s.charAt(idx);
            if (hs.contains(character)) {
                length += 2;
                hs.remove(character);
            } else {
                hs.add(character);
            }
        }
        
        if (!hs.isEmpty()) {
            length++;
        }
        
        return length;
    }
}