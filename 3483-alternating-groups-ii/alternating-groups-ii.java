class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;

        // ✅ Step 1: Handle special case where k == 1
        // Every single tile itself is a valid alternating group.
        if (k == 1) return n; 
        
        // ✅ Step 2: Precompute alternation differences
        // `diff[i] = 1` means colors[i] alternates with colors[i+1], otherwise it's 0.
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = (colors[i] != colors[(i + 1) % n]) ? 1 : 0;
        }
        
        // ✅ Step 3: Compute the first window sum (sum of first `k-1` differences)
        int validGroups = 0;  // Tracks the number of valid alternating groups
        int windowSum = 0;    // Stores the count of alternating tiles in the current window
        
        // Compute the initial sum for the first `k-1` window
        for (int i = 0; i < k - 1; i++) {
            windowSum += diff[i];
        }
        
        // If the first window is valid, count it
        if (windowSum == k - 1) validGroups++;
        
        // ✅ Step 4: Slide the window across the circular array
        for (int i = 1; i < n; i++) {
            // Slide the window:
            // - Remove the element that is leaving (diff[i - 1])
            // - Add the new incoming element (diff[(i + k - 2) % n])
            windowSum = windowSum - diff[i - 1] + diff[(i + k - 2) % n];

            // If the new window is a valid alternating group, count it
            if (windowSum == k - 1) validGroups++;
        }
        
        // ✅ Step 5: Return the total count of valid alternating groups
        return validGroups;
    }
}
