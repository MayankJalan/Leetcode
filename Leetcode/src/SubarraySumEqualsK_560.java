public class SubarraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {
        int left=0,right=0,sum=0;
        int n=nums.length;
        int ans=0;
        while(right<n){
            while(right<n && sum<k){
                sum+=nums[right++];
            }
            while(left <right && sum >=k){
                if(sum==k){
                    ans++;
                }
                sum-=nums[left++];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int num[]={1};
        int k=0;
        new SubarraySumEqualsK_560().subarraySum(num,k);

    }
}
