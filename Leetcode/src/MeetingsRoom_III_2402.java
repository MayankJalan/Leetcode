import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingsRoom_III_2402 {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> free=new PriorityQueue<>();
        PriorityQueue <int[]> worker=new PriorityQueue <>((a,b)-> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);
        int ans[]=new int[n];

        for(int i=0;i<n;i++){
            free.add(i);
        }

        for(int i=0;i<meetings.length;i++){

            int start=meetings[i][0];
            int end=meetings[i][1];
            while(!worker.isEmpty() && worker.peek()[1]<=start){
                int room=worker.poll()[0];
                free.add(room);
            }
            if(!free.isEmpty()){
                int room=free.poll();
                ans[room]++;
                int temp[]={room,end};
                worker.add(temp);
            }
            else{
                int room[]=worker.poll();
                ans[room[0]]++;
                int temp[]={room[0],room[1]+end-start};
                worker.add(temp);
            }

        }

        int res=0,max=0;
        for(int i=0;i<n;i++){
            if(max<ans[i]){
                res=i;
                max=ans[i];
            }
        }
        //   System.out.println(Arrays.toString(ans));
        return res;

    }

    public static void main(String[] args) {

        int n = 4; // Total number of meeting rooms
        int[][] meetings = {
                {18, 19}, // Meeting 1: Start time 18, End time 19
                {3, 12},  // Meeting 2: Start time 3, End time 12
                {17, 19}, // Meeting 3: Start time 17, End time 19
                {2, 13},  // Meeting 4: Start time 2, End time 13
                {7, 10}   // Meeting 5: Start time 7, End time 10
                // Add more meetings as needed
        };

        int result = new MeetingsRoom_III_2402().mostBooked(n, meetings);

    }
}
