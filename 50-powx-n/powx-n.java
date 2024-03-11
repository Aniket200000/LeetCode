class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double half = myPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return n > 0 ? x * half * half : (1 / x) * half * half;
        }
    }
}
