class Solution {
    public String sortVowels(String s) {
        String vowels = "aeiouAEIOU";
        List<Character> vowelList = new ArrayList<>();
        
        for (char c : s.toCharArray()) 
            if (vowels.indexOf(c) >= 0) vowelList.add(c);
        
        Collections.sort(vowelList);
        
        char[] result = s.toCharArray();
        int index = 0;
        for (int i = 0; i < result.length; i++) 
            if (vowels.indexOf(result[i]) >= 0) 
                result[i] = vowelList.get(index++);
        
        return new String(result);
    }
}
