import java.util.Arrays;

public class M_Colouring_Problem {
    public static String graphColoring(int [][]mat, int m) {
        int v=mat.length;
        int colour[]=new int[v];
        Arrays.fill(colour,-1);
        for(int i=0;i<v;i++){
            if(colour[i] == -1){
                if(!dfs(mat,i,colour,m,v)){
                    return "NO";
                }
            }
        }

        return "YES";

        // Write your code here
    }

    private static  boolean dfs(int [][]mat, int ind , int colour[], int m, int n){
        if(ind==n){
            return true;
        }

        for(int i=0;i<m ; i++){
            if(isSafe(mat, ind , i, colour)){
                colour[ind]=i;
                if(dfs(mat, ind+1, colour, m,n)){
                    return true;
                }
                colour[ind]=-1;
            }
        }
        return false;
    }

    private static boolean isSafe(int mat[][], int ind, int col, int colour[]){
        for(int i=0;i<mat[ind].length ; i++){
            if(mat[ind][i]!=0 && colour[i]==col){
                return false;
            }
        }
        return true;
    }
}
