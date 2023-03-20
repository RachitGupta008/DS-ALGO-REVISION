class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return head;
        }
        if(head.next==null){
            return head;
        }
        head = swap(head, head.next);
        head.next.next = swapPairs(head.next.next);
        return head;
        
    }
    
    public ListNode swap(ListNode h , ListNode k){
        
        h.next = k.next;
        k.next = h;
        return k;
        
        
    }
}
