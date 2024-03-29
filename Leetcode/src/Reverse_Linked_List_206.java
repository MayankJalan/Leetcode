public class Reverse_Linked_List_206 {
    public ListNode reverseList(ListNode head) {
        ListNode curr=head, prev=null, next=null;
        while(curr !=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
