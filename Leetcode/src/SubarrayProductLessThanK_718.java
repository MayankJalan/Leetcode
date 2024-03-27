public class SubarrayProductLessThanK_718 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int left=0, right=0;
        int prod=1;
        int count=0;
        while(left <=right && right<n){
            prod*=nums[right];
            if(prod<k){
                System.out.println(left+"  "+right);
                count++;
                right++;
                continue;
            }
            while(left <= right && prod>=k){
                prod/=nums[left++];
            }
            if(prod<k){
                System.out.println(left+"  "+right);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int num[]={10,5,2,6};
        new SubarrayProductLessThanK_718().numSubarrayProductLessThanK(num,100);
    }
}
