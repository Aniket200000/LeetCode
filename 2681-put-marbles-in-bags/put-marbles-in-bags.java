class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;

        if(k==1) return 0;
        int[] diff = new int[n-1]; 

        for(int i = 0 ; i < n-1 ; i++){
            diff[i] = weights[i] + weights[i+1];
        }
        Arrays.sort(diff);

        long maxSum = 0 , minSum = 0;

        for(int i = 0 ;i < k-1 ; i++){
            minSum += diff[i];       // Smallest k-1 differences
            maxSum += diff [n-2-i];  // Largest k-1 differences
        }
        return maxSum-minSum;
    }
}