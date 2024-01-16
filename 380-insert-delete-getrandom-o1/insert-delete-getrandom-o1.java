class RandomizedSet {


HashMap<Integer,Integer> hashmap ;
List<Integer> list ;
    public RandomizedSet() {
        hashmap = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(hashmap.containsKey(val)) return false;
        list.add(val);
        hashmap.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!hashmap.containsKey(val)) return false;
        int ind = hashmap.get(val);
        Collections.swap(list,ind,list.size()-1);
        int swappedWith = list.get(ind);
        hashmap.put(swappedWith , ind);
        list.remove(list.size()-1);
        hashmap.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        int  n = random.nextInt(list.size());
        return list.get(n);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */