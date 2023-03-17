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
    public ListNode reverseBetween(ListNode head, int left, int right){

        if(head == null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(-1, head);

        int cnt = 0;

        ListNode prev = dummy;
        ListNode c = head;
        ListNode n = head.next;
        ListNode r = null;
        ListNode l = null;

        for(int i=1;i<=right;i++){
            if(i<left || i>right){
                prev = c;
                c=c.next;
                n = c.next;
            }

            if(i>=left && i<=right){
                if(i==left){
                    l = prev;
                }
                
                n = c.next;
                c.next = prev;
                prev = c;
                c = n;
               

                if(i==right){
                    r = n;
                    l.next.next = r;
                    l.next = prev;
                }

            }
        }

        return dummy.next;

    }

    public ListNode reverseBetwen(ListNode head, int left, int right) {
        
        ListNode mid = null;
        ListNode r = head;
        ListNode l = null;
        ListNode s = head;
        ListNode m1 = null;
        if(left==right){
            return head;
        }
        
        for(int i=1;i<=right;i++){
            
            if(i<left){
                r = s;
                s = s.next;
                
            }
            
            if(i>=left && i<=right){
                if(i==left){
                    mid = s;
                    m1 = s;
                    
                    s= s.next;
                    mid.next = null;
                    continue;
                }
                
                ListNode temp = s.next;
                s.next = mid;
                mid = s;
                s=temp;
                
                if(i==right){
                    l = s;
                }
                
                
            }
            
        }
        if(r!=mid){
           r.next = mid; 
        }
        if(m1!=l){
           m1.next = l;  
        }
        
        if(left == 1){
            head = mid;
        }
       
        
        return head;
    }
}
