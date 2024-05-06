/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();

        // Push all nodes onto the stack
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        // Start building the new list from the end
        ListNode newHead = stack.pop();  // the last node becomes the new head
        int maxVal = newHead.val;        // start with the last node's value as the maximum

        // Build the list backwards, ensuring all nodes have values >= maxVal seen so far
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();  // pop the next node from the stack

            if (node.val >= maxVal) {  // only keep nodes with value >= current maximum
                node.next = newHead;  // connect the new node to the current head
                newHead = node;       // update new head
                maxVal = node.val;    // update the maximum value seen
            }
        }

        return newHead;
    }
}