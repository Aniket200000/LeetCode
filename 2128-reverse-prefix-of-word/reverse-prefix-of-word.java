class Solution {
    public String reversePrefix(String word, char ch) {
       char[] arr = word.toCharArray();
        int firstOccurrenceIndex = -1;

        // Find the first occurrence of 'ch'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch) {
                firstOccurrenceIndex = i;
                break;  // Exit the loop once the first occurrence is found
            }
        }

        // If 'ch' is not found, return the original word
        if (firstOccurrenceIndex == -1) {
            return word;
        }

        // Create a StringBuilder to reverse the substring
        StringBuilder reversed = new StringBuilder();
        
        // Append characters from firstOccurrenceIndex to 0 (in reverse order)
        for (int i = firstOccurrenceIndex; i >= 0; i--) {
            reversed.append(arr[i]);
        }

        // Append the rest of the string from firstOccurrenceIndex + 1 to the end
        for (int i = firstOccurrenceIndex + 1; i < arr.length; i++) {
            reversed.append(arr[i]);
        }

        // Return the final result as a string
        return reversed.toString();
    }
}