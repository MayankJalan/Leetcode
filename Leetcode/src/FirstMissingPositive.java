import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int val=Math.abs(nums[i]);
            if(val <=n){
                if(nums[val-1]==0){
                    nums[val-1]=-1*(n+1);
                }
                if(nums[val-1]>0)
                    nums[val-1]*=-1;
            }

        }
        System.out.println(Arrays.toString(nums));

        for(int i=1;i<=n;i++){
            if(nums[i-1]>=0){
                return i;
            }
        }



        return n+1;

    }

    public static void main(String[] args) {
        int arr[]={1,1};
        new FirstMissingPositive().firstMissingPositive(arr);
    }
}
