class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int nondups = 0  ;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0  ; i< nums.length ;i++){
            if(!set.contains(nums[i])){
            set.add(nums[i]);
            nums[nondups] = nums[i];
            nondups++;
            }
        }
        return nondups;
    }
}