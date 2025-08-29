class Solution {
    public long flowerGame(int n, int m) {
        // Count even and odd numbers in [1, n]
        long evenX = n / 2;
        long oddX = n - evenX;

        // Count even and odd numbers in [1, m]
        long evenY = m / 2;
        long oddY = m - evenY;

        // Calculate the number of pairs where sum is odd:
        // (evenX * oddY) + (oddX * evenY)
        return evenX * oddY + oddX * evenY;
    }
}
