

class Solution {
    boolean flag = false;
    
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if (start == end) return true;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        dfs(map, visited, start, end);
        return flag;
    }

    private void dfs(Map<Integer, List<Integer>> map, boolean[] visited, int start, int end) {
        if (visited[start] || flag) return;
        
        visited[start] = true;
        
        for (int nei : map.get(start)) {
            if (nei == end) {
                flag = true;
                break;
            }
            if (!visited[nei]) {
                dfs(map, visited, nei, end); 
            }
        }
    }
}
