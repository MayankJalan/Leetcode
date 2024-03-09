public class Minimum_Common_Value_2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        int ind1=0, ind2=0;
        int n=nums1.length;
        int m=nums2.length;

        while(ind1<n && ind2 <m){
            if(nums1[ind1]==nums2[ind2]){
                return nums1[ind1];
            }
            else if(nums1[ind1]>nums2[ind2]){
                ind2++;
            }
            else{

                ind1++;
            }
        }
        return -1;
    }
}
