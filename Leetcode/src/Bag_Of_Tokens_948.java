import java.util.Arrays;

public class Bag_Of_Tokens_948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n=tokens.length;
        int ans=0;
        int left=0,right=n-1;
        int max=0;
        while(left <=right){
            if(power>=tokens[left]){
                ans++;
                power-=tokens[left++];

            }
            else{
                if(left==0){
                    return ans;
                }
                else if(ans>0){
                    ans--;
                    power+=tokens[right--];
                }
                else{
                    return max;
                }
            }
            max=Math.max(ans,max);

        }




        return max;

    }
}
