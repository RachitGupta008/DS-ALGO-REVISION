import java.util.*;
public class ReverseLinkedList{

    public static int findLength(LinkedListNode start)
    {
        LinkedListNode current = start;
        int count = 0;
        while(current != null)
        {
            current = current.next;
            count += 1;
        }
        return count;
    }
    o(2n)
    public static LinkedListNode reverseLinkedList(LinkedListNode head, int k) {
      // Write your code here
      // Tip: You may use some of the code templates provided
      // in the support files
    if(head==null || head.next==null){
      return head;
    }

    LinkedListNode prev = null;
    LinkedListNode curr = head;
    LinkedListNode next = head.next;
    LinkedListNode dummy = new LinkedListNode(-1);
    dummy.next = head;
    LinkedListNode le = dummy;
    LinkedListNode lf=null;
    int cnt = 0;
    int len = findLength(head);
    while(len>=k){
      // reverse the group fully
      cnt = 0;
      while(cnt!=k){
        
        if(cnt == 0){
          lf = curr;
        }
        cnt++;
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        
       
        if(cnt == k){
          le.next = prev;
          lf.next = next;
          le = lf;
        }

      }
      prev = null;
      
      len = len - k;

    }



    return dummy.next;
  }
  O(n+k)
   public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = new ListNode(-1);
        ListNode d = a;
        ListNode b = null;
        ListNode c = head;
        ListNode ptr = null;
        int cnt = 0;

        while(c!=null){
            cnt = 0;
            while(cnt!=k && c!=null){
                ListNode temp = c.next;
                c.next = b;
                if(b==null){
                    ptr = c;
                }
                b = c;
                c = temp;
                cnt++;
            }
            if(cnt!=k){
                b = reverse(b);
            }
            a.next = b;
            a = ptr;
            b = null;
            ptr = null;

        }

        return d.next;

        }

    ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode t = null;

        while(temp!=null){
            ListNode tp = temp;
            temp = temp.next;
            tp.next = t;
            t = tp;
            
        }
        return t;

    }
}
