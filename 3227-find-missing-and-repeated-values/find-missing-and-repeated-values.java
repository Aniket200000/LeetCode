class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
    int n = grid.length;
    int last = n * n;
    HashSet<Integer> seen = new HashSet<>();
    int duplicate = -1, missing = -1;

    for (int[] row : grid) {
        for (int num : row) {
            if (!seen.add(num)) duplicate = num; 
        }
    }

    for (int k = 1; k <= last; k++) {
        if (!seen.contains(k)) {
            missing = k;
            break;
        }
    }

    return new int[]{duplicate, missing};
}
}
