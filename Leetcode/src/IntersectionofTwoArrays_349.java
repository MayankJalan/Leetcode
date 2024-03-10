import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntersectionofTwoArrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> map=new HashSet<>();
        for(int i : nums1){
            map.add(i);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i : nums2){
            if(map.contains(i)){
                ans.add(i);
                map.remove(i);
            }
        }
        int a[]=new int[ans.size()];
        int j=0;
        for(int i : ans){
            a[j++]=i;
        }
        return a;
    }
}
