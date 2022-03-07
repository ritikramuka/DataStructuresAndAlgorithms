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
    public ListNode mergeKLists(ListNode[] Lists) {
        if(Lists.length==0)
            return null;
        return mergeKLists_(Lists,0,Lists.length-1);
    }
    public ListNode mergeKLists_(ListNode[] Lists,int si,int ei)
    {
        if(si==ei)
            return Lists[si];
        // if(si+1==ei)                            //optional case;
        //     return mergeList(Lists[si],Lists[si+1]);   
        int mid=(si+ei)/2;
        return mergeList(mergeKLists_(Lists,si,mid),mergeKLists_(Lists,mid+1,ei));
    }
    public ListNode mergeList(ListNode l1, ListNode l2)
    {
        if(l1==null || l2==null)
            return l1==null?l2:l1;
        ListNode curr1=l1;
        ListNode curr2=l2;
        ListNode dumHead=new ListNode(0);
        ListNode Head=dumHead;
        while(curr1!=null && curr2!=null) {
            if(curr1.val<=curr2.val) {
                Head.next=curr1;
                Head=Head.next;
                curr1=curr1.next;
            } else {
                Head.next=curr2;
                Head=Head.next;
                curr2=curr2.next;
            }
        }
        if(curr1==null)
            Head.next=curr2;
        else
            Head.next=curr1;
        return dumHead.next;
    }
}