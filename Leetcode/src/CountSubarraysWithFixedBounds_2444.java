public class CountSubarraysWithFixedBounds_2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int dirtyInd=-1, minInd=-1,maxInd=-1;
        long ans=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<minK || nums[i]>maxK){
                dirtyInd=i;
            }
            if(nums[i]==minK){
                minInd=i;
            }
            if(nums[i]== maxK){
                maxInd=i;
            }
            ans+=Math.max(0, Math.min(minInd,maxInd)-dirtyInd);
        }
        return ans;
    }
}
