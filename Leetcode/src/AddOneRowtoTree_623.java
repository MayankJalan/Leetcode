import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowtoTree_623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode node=new TreeNode(val);
            node.left=root;
            return node;
        }
        depth --;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(depth-1 !=0){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode node =q.poll();
                if(node.left !=null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            depth--;
        }

        while(!q.isEmpty()){
            TreeNode node =q.poll();
            TreeNode l=new TreeNode(val);
            TreeNode r=new TreeNode(val);

            TreeNode lef=null;
            if(node.left !=null){
                lef=node.left;
            }
            TreeNode righ=null;
            if(node.right != null)
                righ=node.right;

            node.left=l;
            node.right=r;
            l.left=lef;
            r.right=righ;
        }

        return root;




    }
}
