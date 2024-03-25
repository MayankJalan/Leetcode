import java.util.LinkedList;
import java.util.List;

public class FindAllDuplicatesInanArray_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans=new LinkedList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int val=Math.abs(nums[i]);

            if(nums[val-1]<0){
                ans.add(val);
            }
            else{
                nums[val-1]*=-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[]={5,4,6,7,9,3,10,9,5,6};
        List<Integer> ans= new FindAllDuplicatesInanArray_442().findDuplicates(nums);
        System.out.println(ans);
    }
}
