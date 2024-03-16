import java.util.HashMap;

public class ContiguousArray_525 {
    public int findMaxLength(int[] nums) {
        int ans=0, n =nums.length;
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            if(nums[i]==0){
                nums[i]=-1;
            }
        }

        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum==0){
                ans=i+1;
            }
            else if(map.containsKey(sum)){
                ans=Math.max(ans, i-map.get(sum));
            }
            else
                map.put(sum,i);
        }

        return ans;
    }
}
