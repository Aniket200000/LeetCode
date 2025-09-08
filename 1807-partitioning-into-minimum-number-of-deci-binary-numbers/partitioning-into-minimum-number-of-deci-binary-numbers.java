class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(int i = 0 ; i < n.length() ; i++){
            int digit = n.charAt(i) - '0';
            max = Math.max(digit,max);
        }
        return max;
    }
}