public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int ind=0,count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] != val){
                int temp=nums[ind];
                nums[ind]=nums[i];
                nums[i]=temp;
                ind++;
                count++;
            }
        }
        return count;
    }
}
