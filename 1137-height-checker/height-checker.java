class Solution {
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] clone = heights.clone();
        Arrays.sort(clone);

        for(int i = 0 ; i < heights.length ; i++){
            if(heights[i] != clone[i]){
                count++;
            }
        }
        return count;
    }
}