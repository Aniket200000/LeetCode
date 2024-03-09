import java.util.HashSet;

public class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        for (int val : nums1) {
            set1.add(val);
        }
        
        for (int val : nums2) {
            if (set1.contains(val)) {
                set2.add(val);
            }
        }

        return set2.isEmpty() ? -1 : set2.stream().min(Integer::compareTo).orElse(-1);
    }
}
