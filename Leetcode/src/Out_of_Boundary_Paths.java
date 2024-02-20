import java.util.Arrays;

public class Out_of_Boundary_Paths {
    int mod=(int)(1e9) + 7;
    public int findPaths(int n, int m, int maxMove, int startRow, int startColumn) {
        long dp[][][]=new long[n][m][maxMove+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }


        return (int) dfs(startRow, startColumn , n,m,maxMove, dp );

    }

    private long dfs(int i, int j, int n, int m, int maxMove , long dp[][][] ) {

        if(i<0 || j<0 || i>=n || j>=m){
            return 1;
        }
        if(maxMove <= 0){
            return 0;
        }

        if(dp[i][j][maxMove] != -1){
            return dp[i][j][maxMove];
        }

        long ways= (dfs(i+1,j,n,m,maxMove-1, dp) % mod+
                dfs(i-1,j,n,m,maxMove-1, dp) % mod+
                dfs(i,j-1,n,m,maxMove-1, dp) % mod+
                dfs(i,j+1,n,m,maxMove-1, dp) % mod ) % mod;

        return dp[i][j][maxMove]=(ways%mod);






    }



    public static void main(String args[]){
        Out_of_Boundary_Paths outOfBoundaryPaths=new Out_of_Boundary_Paths();
        outOfBoundaryPaths.findPaths(1,3,3,0,1);
    }

}
