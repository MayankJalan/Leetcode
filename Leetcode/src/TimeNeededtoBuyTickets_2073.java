public class TimeNeededtoBuyTickets_2073 {
    public int timeRequiredToBuy(int[] nums, int k) {
            int val=nums[k];
            int ans=0;

            for(int i=0;i<nums.length;i++){
                if(i<=k){
                    ans+=Math.min(val,nums[i]);
                }
                else{
                    ans+=Math.min(nums[i], val -1);
                }
            }
            return ans;
        }
}
