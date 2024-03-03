public class Remove_Nth_Node_From_End_Of_List_19 {
    public ListNode removeNthFromEnd(ListNode head, int nth) {
        int n=length(head);
        n=n-nth;
        if(n==0){
            return head.next;
        }
        ListNode curr=head,prev=null;
        int k=0;
        while(k!=n){
            prev=curr;
            curr=curr.next;
            k++;
        }
        if(curr != null){
            prev.next=curr.next;
        }

        return head;
    }

    public int length(ListNode head){
        int n=0;
        while(head!=null){
            head=head.next;
            n++;
        }
        return n;
    }
}
