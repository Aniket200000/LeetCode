class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int groups = 0 ;
        int n = colors.length;
        for (int i = 0; i < n; i++) {
            int left = colors[(i - 1 + n) % n];   // Left neighbor (circular)
            int mid = colors[i];                  // Current element
            int right = colors[(i + 1) % n];      // Right neighbor (circular)

            // Check if the middle element is different from both neighbors
            if (mid != left && mid != right) {
                groups++;
            }
        }
        return groups;
    }
}