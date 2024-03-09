import java.util.Arrays;

public class Is_Graph_Bipartite_785 {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int colour[]=new int[n];
        Arrays.fill(colour, -1);
        for(int i=0;i<n;i++){
            if(colour[i]==-1){
                if(dfs(i,graph,1, colour)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int ind, int [][]graph, int paint , int colour[]){
        colour[ind]=paint;
        for(int i=0; i<graph[ind].length;i++ ){
            int neigh=graph[ind][i];
            if(colour[neigh]==paint){
                return true;
            }
            if(colour[neigh]==-1){
                if(dfs(neigh,graph,1-paint,colour)){
                    return true;
                }
            }
        }
        return false;
    }
}
