import java.util.LinkedList;
import java.util.Queue;
public class FindBottomLeftValue_513 {
    int dep;
    public int findBottomLeftValue(TreeNode root) {
        dep=0;
        findDepth(root,0);
        System.out.println(dep);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int d=0;
        while(!q.isEmpty()){

            int n=q.size();
            if(d==dep){
                return q.peek().val;
            }
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }
            d++;

        }

        return -1;
    }

    private void findDepth(TreeNode node, int d){
        if(node==null){
            dep=Math.max(dep, d-1);
            return;
        }
        findDepth(node.left, d+1);
        findDepth(node.right,d+1);
    }
}
