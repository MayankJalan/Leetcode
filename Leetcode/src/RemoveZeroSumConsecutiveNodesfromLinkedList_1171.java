import java.util.HashMap;
public class RemoveZeroSumConsecutiveNodesfromLinkedList_1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer,ListNode> map=new HashMap<>();
        ListNode curr=head;
        ListNode prev=null;

        int sum=0;
        while(curr != null){
            sum+=curr.val;
            if(sum==0){
                head=curr.next;
                prev=null;
                map.clear();
            }
            else if(map.containsKey(sum)){

                prev=map.get(sum);
                ListNode temp=prev.next;;
                int currSum=sum;
                while(temp != curr){
                    currSum+=temp.val;
                    map.remove(currSum);
                    temp=temp.next;
                }
                prev.next=curr.next;
            }
            else
                map.put(sum, curr);
            prev=curr;
            curr=curr.next;
        }

        return head;
    }
}
