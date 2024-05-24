/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right; 
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;  // Base case: no elements to form a node
        }

        int mid = (left + right) / 2; // Find the middle element
        TreeNode root = new TreeNode(nums[mid]); // Create a node with the middle element
        root.left = sortedArrayToBST(nums, left, mid - 1); // Recursively build the left subtree
        root.right = sortedArrayToBST(nums, mid + 1, right); // Recursively build the right subtree
        return root;
    }
}
