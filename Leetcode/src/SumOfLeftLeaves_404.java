import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null){
                TreeNode leftLeaf=node.left;
                if(leftLeaf.left==null && leftLeaf.right ==null)
                    sum+=leftLeaf.val;
                q.add(leftLeaf);
            }
            if(node.right!=null){
                q.add(node.right);
            }
        }
        return sum;

    }
}
