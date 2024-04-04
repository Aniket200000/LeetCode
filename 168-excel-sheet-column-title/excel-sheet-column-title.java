class Solution {
    public String convertToTitle(int columnNumber) {
         StringBuilder sol = new StringBuilder();
        while (columnNumber > 0) {
            int temp = (columnNumber - 1) % 26; 
            sol.append((char) ('A' + temp));
            columnNumber = (columnNumber - 1) / 26;
        }
        return sol.reverse().toString(); 
    }
}