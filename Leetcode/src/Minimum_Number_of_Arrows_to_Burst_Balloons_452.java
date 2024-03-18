import java.util.Arrays;

public class Minimum_Number_of_Arrows_to_Burst_Balloons_452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) ->  Integer.compare(a[0],b[0]));

        long start=points[0][0];
        long end=points[0][1];
        int n=points.length, res=1;

        for(int i=1;i<n; i++){
            if(points[i][0]<=end){
                start=Math.max(start,points[i][0]);
                end=Math.min(end,points[i][1]);
            }
            else{
                res++;
                start=points[i][0];
                end=points[i][1];
            }

        }
        return res;
    }
}
