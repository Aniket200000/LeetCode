class Solution {
    public boolean wordPattern(String pattern, String s) {
    String[] words = s.split("\\s+");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char patternChar = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(patternChar)) {
                if (!charToWord.get(patternChar).equals(word)) {
                    return false;
                }
            } else {
                if (wordToChar.containsKey(word)) {
                    return false;
                }
                charToWord.put(patternChar, word);
                wordToChar.put(word, patternChar);
            }
        }
        return true;
    }
}