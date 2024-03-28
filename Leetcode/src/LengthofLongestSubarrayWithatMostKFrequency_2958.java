import java.util.HashMap;
public class LengthofLongestSubarrayWithatMostKFrequency_2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int left=0, right=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        int n=nums.length, ans=0;
        while(right<n){
            int val=nums[right];
            map.put(val,map.getOrDefault(val,0)+1);
            while(left<=right && map.get(val)>k){
                int va=nums[left++];
                map.put(va,map.getOrDefault(va,0)-1);
            }
            ans=Math.max(ans,(right-left+1));
            right++;

        }
        return ans;
    }
}
