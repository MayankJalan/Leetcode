import java.util.ArrayList;

public class MergeIntervals_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int []> arr=new ArrayList<>();
        ArrayList<int []> ans=new ArrayList<>();

        int i=0;
        for(;i<intervals.length; i++){
            if(intervals[i][0]<newInterval[0]){
                arr.add(intervals[i]);
            }
            else{
                break;
            }
        }
        arr.add(newInterval);
        for(;i<intervals.length;i++){
            arr.add(intervals[i]);
        }

        int start=arr.get(0)[0];
        int end=arr.get(0)[1];

        for(i=1;i<arr.size();i++){
            if(arr.get(i)[0]<=end ){
                end=Math.max(arr.get(i)[1] ,end );
            }
            else{
                int x[]={start,end};
                ans.add(x);
                start=arr.get(i)[0];
                end=arr.get(i)[1];
            }
        }
        int x[]={start,end};
        ans.add(x);
        int res[][]=new int[ans.size()][2];
        for(int j=0;j<ans.size();j++){
            res[j]=ans.get(j);
            //  System.out.println(Arrays.toString(res[j]));
        }
        return res;
    }
}
