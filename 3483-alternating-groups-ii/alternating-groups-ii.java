class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int groups = 0 ;
        int n = colors.length;
        int left = 0;

        for(int right = 1 ; right < n + k - 1 ; right++ ){ // Expanding the window by moving right

            // if alternating elements become same then skip the entire subarray
            if(colors[right % n] == colors[(right - 1)% n]){
                left = right ; 
            }

            if(right - left + 1 == k){
                left++;  // Shrinking the window by moving left
                groups++;
            }
        }
        return groups;
    }
}