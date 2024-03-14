import java.util.HashMap;
public class Binary_Subarrays_With_Sum_930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int prefSum=0;
        map.put(0,1);
        int res=0;
        for(int i=0;i<nums.length;i++){
            prefSum+=nums[i];
            res+=map.getOrDefault(prefSum-goal,0);
            map.put(prefSum,map.getOrDefault(prefSum,0)+1);
        }
        return res;
    }
}