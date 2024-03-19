import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler_621 {
    public int leastInterval(char[] tasks, int k) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(char ch : tasks){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character> pq=new PriorityQueue<>();
        for(char ch : map.keySet()){
            pq.add(ch);
        }
        int ans=0;
        while(pq.size()>0){
            int n=k;
            List<Character> temp=new ArrayList<>();
            while(n>0 && pq.size()>0){
                char ch=pq.poll();
                temp.add(ch);

                ans++;
                n--;
            }
            for(char ch : temp){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)>0){
                    pq.add(ch);
                }
            }
            ans+=n;
        }

        return ans;

    }

    public static void main(String[] args) {
        char []tasks={'A','A','A','B','B','B'};
        new TaskScheduler_621().leastInterval(tasks,2);
        
    }
}
