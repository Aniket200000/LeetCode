class Solution {
    public int numberOfPairs(int[][] points) {
        return Optimized(points);
    }
    
    private int Optimized(int[][] points){
        int n = points.length;
        int ans = 0;
        
        Arrays.sort(points, (a, b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        
        for(int i = 0; i < n; i++){
            int y1 = points[i][1];
            int maxY = Integer.MIN_VALUE;
            
            for(int j = i + 1; j < n; j++){
                int y2 = points[j][1];
                
                if(y2 > y1){
                    continue;
                }
                
                if(y2 > maxY){
                    ans++;
                    maxY = y2;
                }
            }
        }
        
        return ans;
    }
    
    private boolean isValid(int[][] points, int i, int j){
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];
        
        for(int p = 0; p < points.length; p++){
            if(p == i || p == j){
                continue;
            }
            
            int x = points[p][0];
            int y = points[p][1];
            
            if(x <= x2 && x >= x1 && y <= y1 && y >= y2) {
                return false;
            }
        }
        return true;
    }
}
