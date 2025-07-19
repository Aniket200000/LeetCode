class Solution {
    public boolean isHappy(int n) {
    HashSet<Integer> set = new HashSet<>();
    while (n != 1 && !set.contains(n)) {
        set.add(n);
        n = sumOfSquares(n);
    }
    return n == 1;
}

private int sumOfSquares(int n){
    int output = 0;
    while(n > 0){
        int sl_digit = n % 10;
        output += sl_digit * sl_digit;
        n = n / 10;
    }
    return output;
}

}