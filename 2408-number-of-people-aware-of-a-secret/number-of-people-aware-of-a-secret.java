class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        long sharing = 0;
        
        for (int day = 2; day <= n; day++) {
            sharing = (sharing + dp[Math.max(0, day - delay)] - dp[Math.max(0, day - forget)] + MOD) % MOD;
            dp[day] = sharing;
        }
        
        long result = 0;
        for (int i = Math.max(1, n - forget + 1); i <= n; i++) {
            result = (result + dp[i]) % MOD;
        }
        return (int) result;
    }
}
