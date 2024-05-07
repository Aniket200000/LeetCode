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
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode temp = head;
        int carry = 0;
        while( temp != null){
            int x = temp.val;
            int s = ((2 * x) % 10) + carry ;
            carry = (2 * x) / 10 ;
            temp.val = s ;
            temp = temp.next;
        }
        head = reverse(head);
        if(carry == 1){
            ListNode ld = new ListNode();
            ld.val = carry ;
            ld.next = head;
            head = ld;           
            }
        return head;
    }
}