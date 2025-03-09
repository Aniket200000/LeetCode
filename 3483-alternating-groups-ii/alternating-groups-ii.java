class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        if (k == 1) return n; // Each element forms a valid group when k == 1.
        
        // Precompute diff array: diff[i] is 1 if colors[i] != colors[(i+1) % n], else 0.
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = (colors[i] != colors[(i + 1) % n]) ? 1 : 0;
        }
        
        int validGroups = 0;
        int windowSum = 0;
        
        // Build the initial window over diff (of size k-1)
        for (int i = 0; i < k - 1; i++) {
            windowSum += diff[i];
        }
        
        // Check the initial window: if all k-1 pairs are alternating then count it.
        if (windowSum == k - 1) validGroups++;
        
        // Slide the window across the circular diff array.
        // There are exactly n starting positions.
        for (int i = 1; i < n; i++) {
            // Remove the leftmost element and add the new element at the right boundary.
            windowSum = windowSum - diff[i - 1] + diff[(i + k - 2) % n];
            if (windowSum == k - 1) validGroups++;
        }
        
        return validGroups;
    }
}
