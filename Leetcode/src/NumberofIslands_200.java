public class NumberofIslands_200 {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m = grid[0].length;
        int ans=0;
        boolean vis[][]=new boolean [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] =='1'  && !vis[i][j]){
                    ans++;
                    dfs(grid, i, j , n, m , vis);
                }
            }
        }
        return ans;
    }
    private void dfs(char grid[][], int i , int j , int n, int m , boolean vis[][]){
        if(i<0 || i>=n || j<0 || j>=m || vis[i][j] || grid[i][j]=='0'){
            return ;
        }
        vis[i][j]=true;
        dfs(grid, i+1,j,n,m,vis);
        dfs(grid, i-1,j,n,m,vis);
        dfs(grid, i,j+1,n,m,vis);
        dfs(grid, i,j-1,n,m,vis);
    }
}
