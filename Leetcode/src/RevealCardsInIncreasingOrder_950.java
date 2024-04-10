import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder_950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n=deck.length;

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(i);
        }
        int ans[]=new int[n];
        int j=0;
        //   System.out.println(Arrays.toString(deck));
        while(!q.isEmpty()){
            ans[q.poll()]=deck[j++];
            if(!q.isEmpty()){
                q.add(q.poll());
            }
        }
        return ans;
    }
}
