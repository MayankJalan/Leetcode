public class MinimumOperationsToReduceXtoZero {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int reqdSum = sum - x;
        if(reqdSum==0){
            return n;
        }
        sum=0;
        int start = 0;
        int end = 0;
        int max = -1;
        int ans = -1;
        while (end < n) {
            sum += nums[end];

            while (start < end && sum > reqdSum) {
                sum -= nums[start++];
            }
            if (sum == reqdSum) {
                ans = Math.max(ans, (end - start + 1));
            }
            end++;

        }
        return ans == -1 ? ans : n - ans;

    }

    public static void main(String[] args) {
        int arr[]={8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309};
        new MinimumOperationsToReduceXtoZero().minOperations(arr,134365);
    }
}
