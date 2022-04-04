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
    public ListNode swapNodes(ListNode head, int k) {

        ListNode temp = head, left = null, right = null;

        while(temp != null) {
            right = (right == null) ? null : right.next;
            if(--k == 0)    {
                left = temp;
                right = head;
            }
            temp = temp.next;
        }

        int t = left.val;
        left.val = right.val;
        right.val = t;

        return head;

    }
}