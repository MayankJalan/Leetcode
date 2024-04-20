import java.util.ArrayList;
import java.util.List;

public class FindAllGroupsofFarmland_1992 {
    public int[][] findFarmland(int[][] land) {
        int n=land.length;
        int m=land[0].length;
        List<int[]> ans=new ArrayList<>();

        boolean vis[][]=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j]==1 && !vis[i][j]){
                    int temp[]=new int[4];
                    dfs(land,i,j,n,m,temp,vis);
                    ans.add(temp);
                }
            }
        }
        int res[][]=new int[ans.size()][4];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }

        return res;
    }

    public void dfs(int land[][],int i, int j, int n, int m ,int temp[],boolean vis[][] ){
        if(i<0 || j<0 || i>=n || j>=m || land[i][j]==0 || vis[i][j]){
            return;
        }

        if((i==0 && j==0) || (i==0 && land[i][j-1]==0) || (j==0 && land[i-1][j]==0 )|| ((i-1>=0 && j-1>=0 ) && land[i-1][j] ==0 && land[i][j-1]==0)){
            temp[0]=i;
            temp[1]=j;
        }

        if((i==n-1 && j==m-1) || (i==n-1 && land[i][j+1]==0) || (j==m-1 && land[i+1][j]==0 ) || ((i+1<=n-1 && j+1<=m-1) && land[i+1][j] ==0 && land[i][j+1]==0)){
            temp[2]=i;
            temp[3]=j;
        }

        vis[i][j]=true;
        dfs(land,i+1,j,n,m,temp,vis);
        dfs(land,i-1,j,n,m,temp,vis);
        dfs(land,i,j+1,n,m,temp,vis);
        dfs(land,i,j-1,n,m,temp,vis);
    }

    public static void main(String[] args) {
        int[][] land = {{1, 0, 0}, {0, 1, 1}, {0, 1, 1}};
        new FindAllGroupsofFarmland_1992().findFarmland(land);
    }

}
