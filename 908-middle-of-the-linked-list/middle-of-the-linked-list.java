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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head ;
        ListNode slow = head ;
        if( head == null || head.next == null){
            return  head ;
        }
        while(fast != null){
            fast = fast.next;
            if(fast != null){
            fast = fast.next;
            slow = slow.next;
            }
        }
    return slow;
    }
}