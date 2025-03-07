class Solution {
    public int[] closestPrimes(int left, int right) {
        // Special case: If left is 1, the first prime pair should be {2,3}
        if (left <= 2 && right >= 3) {
            return new int[]{2, 3};
        }

        int point1 = left;
        int point2 = point1 + 2;

        int minDif = Integer.MAX_VALUE;
        int[] arr = new int[]{-1, -1};

        while (point2 <= right) {
            if (isEven(point1)) { // Ensure point1 is odd
                point1++;
                point2++;
                if (point2 > right) break; // Minimal fix: check if point2 went out of range
            }

            if (!isPrime(point1)) { // Move point1 to the next prime
                point1++;
                point2 = point1 + 2;
                continue;
            }

            if (!isPrime(point2)) { // Move point2 to the next prime
                point2++;
                continue;
            }

            // Both point1 and point2 are prime now.
            if ((point2 - point1) == 2) { // Found twin primes
                return new int[]{point1, point2};
            }

            int ans = point2 - point1;
            if (ans < minDif) {
                minDif = ans;
                arr[0] = point1;
                arr[1] = point2;
            }

            point1 = point2;
            point2 = point2 + 2;
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

    public boolean isEven(int n) {
        return n % 2 == 0;
    }
}
