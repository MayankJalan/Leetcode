public class FindtheDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {
        for(int i : nums){
            int val=Math.abs(i);
            if(nums[val-1]<0){
                return val;
            }
            else{
                nums[val-1]*=-1;
            }
        }
        return -1;
    }
}
