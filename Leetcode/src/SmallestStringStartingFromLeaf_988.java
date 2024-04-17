public class SmallestStringStartingFromLeaf_988 {
    String ans;
    public String smallestFromLeaf(TreeNode root) {
        ans="";
        dfs(root,"");
        return ans;
    }

    private void dfs(TreeNode root, String temp){
        if(root==null){
            return ;
        }
        char ch =(char) ('a' + root.val);
        temp=String.valueOf(ch) + temp;

        if(root.left == null && root.right==null ){
            if(ans.length()==0 || temp.compareTo(ans) < 0){
                ans=temp;
            }
            return;
        }

        else if(root.left==null)
            dfs(root.right, temp);
        else if(root.right ==null)
            dfs(root.left, temp);
        else{
            dfs(root.right, temp);
            dfs(root.left, temp);
        }
    }
}
