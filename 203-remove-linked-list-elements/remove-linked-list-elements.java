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
    public ListNode removeElements(ListNode head, int val) {
         if (head == null) return null; 

        ListNode dummy = new ListNode(0); 
        dummy.next = head;

        ListNode fast = dummy.next;
        ListNode slow = dummy;

        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;  
            } else {
                slow = slow.next;  
            }
            fast = fast.next; 
        }

        return dummy.next;
    }
}