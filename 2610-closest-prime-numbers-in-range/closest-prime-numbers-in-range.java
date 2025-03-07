class Solution {
    public int[] closestPrimes(int left, int right) {
        // ✅ Special Case: If range includes 2 and 3, return {2,3}.
        if (left <= 2 && right >= 3) {
            return new int[]{2, 3};
        }

        // \U0001f50d Initialize pointers
        int point1 = left;
        int point2 = point1 + 2;
        
        // \U0001f3c6 Track the smallest gap found
        int minDiff = Integer.MAX_VALUE;
        int[] ans = new int[]{-1, -1};

        // \U0001f504 Iterate while point2 is within bounds
        while (point2 <= right) {
            // \U0001f4cc Ensure point1 is odd (even numbers ≠ prime, except 2)
            if (isEven(point1)) {
                point1++;
                point2++;
                if (point2 > right) break;  // ⚠️ Boundary check
            }
            
            // ❌ Skip non-prime point1
            if (!isPrime(point1)) {
                point1++;
                point2 = point1 + 2;
                continue;
            }
            
            // ❌ Skip non-prime point2
            if (!isPrime(point2)) {
                point2++;
                continue;
            }
            
            // \U0001f3af Found a prime pair: Check for twin primes
            if ((point2 - point1) == 2) {
                return new int[]{point1, point2};  // \U0001f525 Best possible answer
            }
            
            // \U0001f525 Update answer if we found a closer pair
            int currentDiff = point2 - point1;
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                ans[0] = point1;
                ans[1] = point2;
            }
            
            // \U0001f504 Move to the next possible prime pair
            point1 = point2;
            point2 = point2 + 2;
        }
        
        return ans;
    }
    
    // \U0001f9ea Helper function: Check if a number is prime (O(√n) approach)
    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    // \U0001f522 Utility function: Check if a number is even
    public boolean isEven(int n) {
        return n % 2 == 0;
    }
}
