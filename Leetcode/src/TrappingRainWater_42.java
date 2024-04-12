public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int max=height[0];
        int n=height.length;
        int left[]=new int [n];

        int right[]=new int [n];
        int ans=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,height[i]);
            left[i]=max;
        }
        max=0;
        for(int i=n-1;i>=0;i--){
            max=Math.max(max,height[i]);
            right[i]=max;
        }
        for(int i=0;i<n;i++){
            ans+=Math.min(left[i],right[i])-height[i];
        }
        return ans;
    }
}
