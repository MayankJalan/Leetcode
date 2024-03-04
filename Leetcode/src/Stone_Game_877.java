public class Stone_Game_877 {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        Nodee dp[][]=new Nodee[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=new Nodee(piles[i],0);
        }
        for(int i=0;i<n-1;i++){
            dp[i][i+1]=new Nodee(Math.max(piles[i], piles[i+1]), Math.min(piles[i], piles[i+1]));
        }

        for(int k=2;k<n;k++){
            for(int i=0;i+k<n;i++){
                int j=i+k;
                int first=piles[i]+dp[i+1][j].second;
                int second=piles[j]+dp[i][j-1].second;
                // if(i==0 && j==n-1){
                //     System.out.println(first);
                //     System.out.println(second);

                // }
                if(first>second){
                    dp[i][j]=new Nodee(first,dp[i+1][j].first);
                }
                else{
                    dp[i][j]=new Nodee(second,dp[i][j-1].first);
                }

            }
        }

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         if(dp[i][j] != null )
        //             System.out.print(dp[i][j].first+ " "+dp[i][j].second+"        ");
        //         else{
        //             System.out.print("0 0        ");
        //         }
        //     }
        //      System.out.println();
        // }


        return dp[0][n-1].first > dp[0][n-1].second;
    }
}
class Nodee{
    int first, second;
    Nodee(int first, int second){
        this.first=first;
        this.second=second;
    }
}
