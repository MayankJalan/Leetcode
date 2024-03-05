public class NumberOfWaysToStayInSamePlaceNo_1269 {
    int mod=1000000007;
    public int numWays(int steps, int n) {
        Integer dp[][]=new Integer[n][steps+1 ];
        int ans=dfs(0,dp,steps,n) % mod ;
        return ans;
    }

    private int dfs(int i, Integer dp[][],int steps, int n){

        if(i==0 && steps==0){
            return 1;
        }
        if(i<0 || i>=n || steps <=0 ){
            return 0;
        }
        if(dp[i][steps] !=null ){
            return dp[i][steps];
        }

        long a=  dfs(i+1 ,dp, steps-1 , n) %mod;
        a= (a+ dfs(i-1 ,dp, steps-1 , n)) % mod;
        a= (a+ dfs(i ,dp, steps-1 , n)) % mod;



        return dp[i][steps] =((int) a) % mod;

    }
    public static void main(String[] args) {
        new NumberOfWaysToStayInSamePlaceNo_1269().numWays(3,2);
    }
}
