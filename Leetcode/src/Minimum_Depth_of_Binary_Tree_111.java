import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Depth_of_Binary_Tree_111 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int depth=1;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                if(curr.left==null && curr.right==null){
                    return depth;
                }
                if (curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }

            }
            depth++;

        }
        return depth;

    }
}
