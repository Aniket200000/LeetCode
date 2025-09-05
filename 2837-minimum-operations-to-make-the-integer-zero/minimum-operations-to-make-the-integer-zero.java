class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for( int step = 1 ; step <= 35 ; step++){
            long diff = num1 - 1l*num2*step;
            if(diff < 0){
                continue;
            }
            int bits = Long.bitCount(diff);
            if(bits <= step && diff >= step){
                return step;
            }
        }
        return -1;
    }
}