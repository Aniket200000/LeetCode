class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        if(head == null || head.next == null) return head;

        while (head != null && head.next != null) {

            ListNode firstNode = head;
            ListNode secondNode = head.next;

            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prev = firstNode;
            head = firstNode.next;
        }

        return dummy.next;
    }
}