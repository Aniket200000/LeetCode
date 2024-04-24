class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        
        // Create an array to store the calculated tribonacci values
        int[] trib = new int[n + 1];
        
        // Base cases
        trib[0] = 0;
        trib[1] = 1;
        trib[2] = 1;
        
        // Fill the array with tribonacci values
        for (int i = 3; i <= n; i++) {
            trib[i] = trib[i - 1] + trib[i - 2] + trib[i - 3];
        }
        
        // Return the nth tribonacci value
        return trib[n];
    }
}