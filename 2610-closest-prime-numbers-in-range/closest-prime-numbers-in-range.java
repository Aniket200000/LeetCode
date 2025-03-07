class Solution {
    public int[] closestPrimes(int left, int right) {
        if (left <= 2 && right >= 3) {
            return new int[]{2, 3};
        }

        int point1 = -1, point2 = -1;  // Store last two primes
        int minDif = Integer.MAX_VALUE;
        int[] arr = new int[]{-1, -1};

        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (point1 == -1) {
                    point1 = i; // First prime found
                } else {
                    point2 = i; // Second prime found
                    int diff = point2 - point1;

                    if (diff < minDif) {
                        minDif = diff;
                        arr[0] = point1;
                        arr[1] = point2;
                    }
                    
                    point1 = point2; // Move to next prime
                }
            }
        }
        return arr;
    }

    public boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
