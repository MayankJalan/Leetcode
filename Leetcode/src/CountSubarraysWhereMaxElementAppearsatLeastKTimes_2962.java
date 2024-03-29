import java.util.*;
public class CountSubarraysWhereMaxElementAppearsatLeastKTimes_2962 {
    public long countSubarrays(int[] nums, int k) {
        int max=Arrays.stream(nums).max().getAsInt();
        int left=0,right=0;
        int n=nums.length;
        int count=0;
        long ans=0;
        while(right<n){
            if(nums[right]==max){
                count++;
            }

            while(left<=right && count>=k){
                if(nums[left]==max ){
                    count--;
                }
                ans+=n-right;
                left++;
            }
            right++;
        }
        return ans;

    }

    public static void main(String[] args) {
        int nums[]={1,3,2,3,3};
        int k=2;
        new CountSubarraysWhereMaxElementAppearsatLeastKTimes_2962().countSubarrays(nums,k);
    }
}
