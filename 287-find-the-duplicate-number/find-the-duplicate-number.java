class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(fast == slow){
                break;
            }
        }
        int pointer1 = nums[0];
        int pointer2 = slow;
        while(pointer1 != pointer2){
            pointer1 = nums[pointer1];
            pointer2 = nums[pointer2];
        }
        return pointer1;
    }
}
