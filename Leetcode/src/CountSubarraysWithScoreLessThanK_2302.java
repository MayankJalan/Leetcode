public class CountSubarraysWithScoreLessThanK_2302 {
    public long countSubarrays(int[] nums, long k) {
        long sum=0;
        int n=nums.length;
        long ans=0;
        int left=0,right=0;

        while(right<n){
            sum+=nums[right];
            while(sum*(right-left+1) >=k){
                sum-=nums[left++];
            }
            ans+=(right-left+1);
            right++;

        }

        return ans;
    }
}
