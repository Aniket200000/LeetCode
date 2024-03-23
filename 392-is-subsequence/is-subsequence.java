class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0; // Declare i and j outside the loops
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        
        while (i < arr1.length && j < arr2.length) { // Loop through both arrays
            if (arr1[i] == arr2[j]) { // If characters match
                i++; // Move to the next character in arr1
            }
            j++; // Move to the next character in arr2 regardless of match
        }
        return i == arr1.length ? true : false;
         // Check if all characters of arr1 have been matched
    }
}
