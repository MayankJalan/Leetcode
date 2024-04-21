import java.util.ArrayList;
import java.util.List;

public class FindifPathExistsinGraph_1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<ArrayList<Integer>> adj=new ArrayList<>();
        if(source == destination)
            return true;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i[] : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        return dfs(adj,source,destination, new boolean[n]);
    }

    private boolean dfs(List<ArrayList<Integer>> adj,int src, int dst, boolean vis[]){
        if(vis[src]){
            return false;
        }

        vis[src]=true;
        for(int i : adj.get(src)){
            if(vis[i]){
                continue;
            }
            if(i==dst){
                return true;
            }
            if(dfs(adj,i,dst,vis)){
                return true;
            }
        }

        return false;
    }
}
