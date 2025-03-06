class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int last = n * n;
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {  
            for (int j = 0; j < grid[i].length; j++) {  
                nums.add(grid[i][j]);
            }
        }

        nums.sort(null);  

        int[] arr = new int[2];

        for (int k = 1; k < nums.size(); k++) {  
            if (nums.get(k).equals(nums.get(k - 1))) {
                arr[0] = nums.get(k);  
                break;  
            }
        }

        for (int k = 1; k <= last; k++) {  
            if (!nums.contains(k)) {  
                arr[1] = k;
                break;
            }
        }

        return arr;
    }

}
