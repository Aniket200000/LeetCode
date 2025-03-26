class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int size = m * n;
        int[] flatGrid = new int[size];

        int index = 0;
        for (int[] row : grid) {
            for (int val : row) {
                flatGrid[index++] = val;
            }
        }

        Arrays.sort(flatGrid);

        int firstElement = flatGrid[0];
        for (int num : flatGrid) {
            if ((num - firstElement) % x != 0) {
                return -1;  
            }
        }

        int median = flatGrid[size / 2]; 

        int totalOperations = 0;
        for (int num : flatGrid) {
            totalOperations += Math.abs(num - median) / x;
        }

        return totalOperations;
    }
}
