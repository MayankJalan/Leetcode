import java.util.HashMap;

public class SubarrayswithKDifferentIntegers_992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int v1=compute(nums,k);
        int v2=compute(nums,k-1);
        return v1-v2;
    }
    public int compute(int []nums,int k){
        int left=0, right=0 , ans=0;
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(right<n){
            int val=nums[right];
            map.put(val,map.getOrDefault(val,0)+1);
            while(map.size()>k){
                int v=nums[left];
                if(map.get(v)==1){
                    map.remove(v);
                }
                else{
                    map.put(v,map.get(v)-1);
                }
                left++;
            }
            ans+=right-left+1;

            right++;

        }
        return ans;
    }

    public static void main(String[] args) {
        int num[]={1,2,1,2,3};
        new SubarrayswithKDifferentIntegers_992().subarraysWithKDistinct(num,2);
    }
}
