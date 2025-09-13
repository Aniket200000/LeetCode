class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        String vowels = "aeiou";
        int maxVowel = 0, maxConsonant = 0;
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (vowels.indexOf(c) >= 0) {
                maxVowel = Math.max(maxVowel, map.get(c));
            } else {
                maxConsonant = Math.max(maxConsonant, map.get(c));
            }
        }
        
        return maxVowel + maxConsonant;
    }
}
