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

 // Algo
 1. find middle element the second one
 2. reverse the list on right side of middle
 3. merge both lists
class Solution {

    ListNode findMid(ListNode n){

        ListNode f = n;
        ListNode s = n;

        while(f!=null && f.next!=null ){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;

        }

        ListNode l = reverse(head.next);

        head.next.next = head;
        head.next = null;
        return l;
    }
    public void reorderList(ListNode head) {
        
        if(head.next == null){
            return;
        }

        ListNode mid = findMid(head);
        ListNode rev = reverse(mid.next);


        mid.next = null;

        ListNode l = head;
        ListNode r = rev;

        while(l!=null && r!=null){
            ListNode temp = l.next;
            ListNode temp2 = r.next;
            l.next = r;
            r.next = temp;

            l = temp;
            r = temp2;

        }


    }
}
