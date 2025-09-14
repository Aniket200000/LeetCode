class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            exact.add(word);
            String lower = word.toLowerCase();
            caseMap.putIfAbsent(lower, word);
            vowelMap.putIfAbsent(vowelMask(lower), word);
        }

        String[] answer = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) { answer[i] = q; continue; }
            String lower = q.toLowerCase();
            if (caseMap.containsKey(lower)) { answer[i] = caseMap.get(lower); continue; }
            String v = vowelMask(lower);
            if (vowelMap.containsKey(v)) { answer[i] = vowelMap.get(v); continue; }
            answer[i] = "";
        }
        return answer;
    }

    private String vowelMask(String s) {
        return s.replaceAll("[aeiou]", "*");
    }
}
