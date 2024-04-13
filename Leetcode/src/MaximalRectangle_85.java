import java.util.Stack;

public class MaximalRectangle_85 {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int max=0;
        int dp[]=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='0'){
                    dp[j]=0;
                }
                else{
                    dp[j]+=1;
                }
            }
            max=Math.max(max,findMax(dp,m));
        }
        return max;
    }
    private static int findMax(int dp[], int n){
        int left[]=new int [n];
        int right[]=new int [n];
        Stack<Integer> stk=new Stack<>();

        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && dp[stk.peek()] >= dp[i]){
                stk.pop();
            }

            if(stk.isEmpty()){
                left[i]=0;
            }
            else{
                left[i]=stk.peek()+1;
            }
            stk.push(i);
        }
        stk.clear();

        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && dp[stk.peek()] >= dp[i]){
                stk.pop();
            }

            if(stk.isEmpty()){
                right[i]=n-1;
            }
            else{
                right[i]=stk.peek()-1;
            }
            stk.push(i);
        }
        // System.out.println(Arrays.toString(dp)+"\n"+Arrays.toString(left)+"\n"+Arrays.toString(right));
        // System.out.println("\n"+"\n");
        int max=0;
        for(int i=0;i<n;i++){
            int val=(right[i]-left[i]+1) * dp[i];
            max=Math.max( val , max);
        }
        return max;

    }
}
