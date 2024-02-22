import java.util.HashMap;
import java.util.PriorityQueue;

public class FindLeastNumOfUniqueInts_1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i : arr){
            map.put(i, map.getOrDefault(i,0)+1);

        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));
        for(int i : map.keySet()){
            pq.add(i);
        }
        while(k>0){
            int no=pq.remove();
            int val=map.get(no);

            if(val<=k){
                k-=val;
            }
            else{
                return pq.size()+1;
            }

        }

        return pq.size();

    }
}
