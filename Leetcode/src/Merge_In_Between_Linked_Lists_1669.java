public class Merge_In_Between_Linked_Lists_1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aNode=null, bNode=null;
        ListNode aNext=null, bNext=null;
        ListNode curr=list1;
        for(int i=1;i<=b+1;i++){
            if(i==a){
                aNode=curr;
            }
            if(i==b+1){
                bNode=curr.next;
            }
            curr=curr.next;
        }
        curr=list2;
        while(curr.next!=null){
            curr=curr.next;
        }
        aNode.next=list2;
        curr.next=bNode;

        return list1;
    }
}
