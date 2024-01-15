class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for(int[] match : matches){
            int winner = match[0];
            int loser = match[1];
            if(!hashmap.containsKey(winner)){
                hashmap.put(winner,0);
            }
             if(!hashmap.containsKey(loser)){
                hashmap.put(loser,0);
            }
            hashmap.put(loser , hashmap.get(loser)+1);
        }  
        List<Integer> zeroloss = new ArrayList();
        List<Integer> oneloss = new ArrayList();

        for(int key : hashmap.keySet()){
            if(hashmap.get(key)==0){
                zeroloss.add(key);
            }
            if(hashmap.get(key)==1){
                oneloss.add(key);
            }
        }
        Collections.sort(zeroloss);
        Collections.sort(oneloss);
        List<List<Integer>> ans = new ArrayList();
        ans.add(zeroloss);
        ans.add(oneloss);
        return ans;
        }
        }
