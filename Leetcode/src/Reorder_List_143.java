import java.util.List;

public class Reorder_List_143 {
    public void reorderList(ListNode head) {
        if(head ==null || head.next==null){
            return ;
        }
        ListNode curr1=head;
        ListNode mid=fidMid(curr1);
        ListNode curr2=mid.next;
        curr2=reverse(curr2);
        mid.next=null;
        while(curr1!=null  && curr2 != null ){
            ListNode pointer=curr2;
            ListNode curr2Next=curr2.next;
            ListNode curr1Next=curr1.next;
            curr1.next=pointer;
            pointer.next=curr1Next;
            curr2=curr2Next;
            curr1=curr1Next;

        }

    }

    private ListNode reverse(ListNode curr2) {

        ListNode prev=null,curr=curr2, next =null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;




    }

    private ListNode fidMid(ListNode curr) {
        ListNode slow=curr,fast=curr;

        while(fast !=null && fast.next != null){
            fast=fast.next.next;
            slow=slow.next;

        }
        return slow;
    }
}
