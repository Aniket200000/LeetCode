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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode fast = list1;
        ListNode slow = null;

        for (int i = 0; i < b; i++) {
            fast = fast.next;
        }

        for (int i = 0; i <= a - 1; i++) {
            if (slow == null) {
                slow = list1;
            } else {
                slow = slow.next;
            }
        }

        if (slow != null) {
            slow.next = list2;
        }

        while (list2 != null && list2.next != null) {
            list2 = list2.next;
        }
        if (list2 != null) {
            list2.next = fast.next;
        }

        return list1;
    }
}
