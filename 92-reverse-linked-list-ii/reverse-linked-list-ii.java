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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head; 

        ListNode now = null; 
        ListNode cut1 = head;
        int pos = 1;

        ListNode temp = head;
        while (pos < left) {
            now = temp;
            temp = temp.next;
            pos++;
        }
        cut1 = temp; 

        while (pos < right) {
            temp = temp.next;
            pos++;
        }
        ListNode cut2 = temp;
        ListNode later = cut2.next;

        
        if (now != null) now.next = null;
        cut2.next = null; 

        ListNode reversedHead = reverseList(cut1);

        
        if (now != null) {
            now.next = reversedHead; 
        } else {
            head = reversedHead; 
        }

        cut1.next = later;

        return head;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
