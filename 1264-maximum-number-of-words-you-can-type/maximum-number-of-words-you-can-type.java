class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> broken = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()) broken.add(ch);

        int count = 0;
        for (String word : text.split(" ")) {
            boolean hasBroken = false;
            for (char ch : word.toCharArray()) {
                if (broken.contains(ch)) {
                    hasBroken = true;
                    break;
                }
            }
            if (!hasBroken) count++;
        }
        return count;
    }
}
