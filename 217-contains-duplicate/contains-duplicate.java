class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();

        for(int num : nums){
            if(numbers.contains(num)){
                return true;
            }
            numbers.add(num);
        }
        return false;
    }
}