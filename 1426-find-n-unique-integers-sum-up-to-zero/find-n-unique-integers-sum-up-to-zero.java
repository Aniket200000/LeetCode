class Solution {
    public int[] sumZero(int n){
        int[] nums = new int[n];
        int idx = 0;
        if(n % 2 != 0) {
            nums[idx++] = 0;
        }
        for(int i = 1; idx < n; i++) {
            nums[idx++] = i;
            nums[idx++] = -i;
        }
        return nums;
    }
}