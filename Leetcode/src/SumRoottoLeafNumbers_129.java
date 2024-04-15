public class SumRoottoLeafNumbers_129 {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int d){
        if(root==null){
            return d;
        }
        d=d*10+root.val;

        if(root.left==null && root.right == null){
            return d;
        }
        if(root.left==null ){
            return helper(root.right, d);
        }
        if(root.right==null){
            return helper(root.left,d);
        }
        int left=helper(root.left,d);
        int right=helper(root.right, d);
        return left+right;
    }
}
