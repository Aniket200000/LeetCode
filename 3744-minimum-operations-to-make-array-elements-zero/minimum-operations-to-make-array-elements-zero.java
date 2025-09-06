class Solution {
    private long get(int num) {
        long total = 0;
        int step = 1;
        int start = 1;
        
        while (start <= num) {
            int end = Math.min(start * 2 - 1, num);
            long rangeLength = end - start + 1;
            long countForStep = ((step + 1) / 2) * rangeLength;
            
            total += countForStep;
            step++;
            start *= 2;
        }
        
        return total;
    }

    public long minOperations(int[][] queries) {
        long operations = 0;
        
        for (int[] range : queries) {
            long countEnd = get(range[1]);
            long countStartMinusOne = get(range[0] - 1);
            operations += (countEnd - countStartMinusOne + 1) / 2;
        }
        
        return operations;
    }
}