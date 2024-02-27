import java.util.LinkedList;
import java.util.Queue;
public class Shortest_Path_In_a_Grid_With_Obstacles_Elimination_1293 {
    class Node{
        int x, y, steps, bricks;
        Node(int x, int y, int steps, int bricks){
            this.x=x;
            this.y=y;
            this.steps=steps;
            this.bricks=bricks;
        }
    }
    public int shortestPath(int[][] grid, int k) {

        int n=grid.length;
        int m = grid[0].length;
        int dx[]={1,-1,0,0};
        int dy[]={0,0,1,-1};
        Queue<Node> q=new LinkedList<>();
        boolean vis[][][]=new boolean[n][m][k+1];
        q.add(new Node(0,0,0,0));
        while(!q.isEmpty()){
            Node node=q.poll();
            if(node.bricks >k || vis[node.x][node.y][node.bricks]){
                continue;
            }
            vis[node.x][node.y][node.bricks]=true;
            if(node.x==n-1 && node.y==m-1){
                return node.steps;
            }
            for(int i=0;i<4;i++){
                int row=node.x+dx[i];
                int col=node.y+dy[i];

                if(row <0 || row>=n || col<0 || col>=m){
                    continue;
                }
                int obs=node.bricks+grid[row][col];
                if(obs<=k){
                    q.add(new Node(row,col , node.steps+1, obs));
                }
            }
        }
        return -1;
    }
}
