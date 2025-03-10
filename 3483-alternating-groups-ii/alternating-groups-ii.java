class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int groups = 0;
        int n = colors.length;
        int left = 0;

        //Skipping the entire subarray
        for (int right = 1; right < (n + k - 1); right++) {// expanding the window
            if (colors[right % n] == colors[(right - 1) % n]) {
                left = right;
            }

            //shrinking the window
            if (right - left + 1 == k) {
                left++;
                groups++;
            }
        }
        return groups;
    }
}