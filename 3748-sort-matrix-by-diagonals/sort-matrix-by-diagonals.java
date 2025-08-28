import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }

        for (int key : map.keySet()) {
            List<Integer> values = map.get(key);
            if (key < 0) {
                Collections.sort(values);  
            } else {
                values.sort(Collections.reverseOrder());  
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                List<Integer> values = map.get(key);
                grid[i][j] = values.remove(0);
            }
        }

        return grid;
    }
}
