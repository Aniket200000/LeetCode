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
   public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) return null;

    int count = 0;
    ListNode p1 = head;
    while (p1 != null) {
        count++;
        p1 = p1.next;
    }

    if (n == count) {
        head = head.next;
        return head;
    }

    ListNode tail = head;
    for (int i = 1; i < count - n; i++) {
        tail = tail.next;
    }
    
    if (tail.next != null) {
        tail.next = tail.next.next;
    }

    return head;
}

}