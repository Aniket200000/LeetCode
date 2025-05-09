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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0) return head;

        int length = 1;
        ListNode last = head;
        while(last.next != null){
            last = last.next;
            length++;
        }

        last.next = head;

        int stepsToNewTail = length - (k % length);
        ListNode newTail = head;

        for(int i = 1 ; i < stepsToNewTail ; i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}