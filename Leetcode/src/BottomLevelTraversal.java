import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BottomLevelTraversal {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            Queue<TreeNode> q=new LinkedList<>();

            List<List<Integer>> ans=new ArrayList<>();
            if(root==null){return ans;}

            q.add(root);
            while(!q.isEmpty()){
                int n=q.size();
                List<Integer> arr=new ArrayList<>();
                for(int i=0;i<n;i++){
                    TreeNode curr=q.poll();
                    arr.add(curr.val);
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }

                }
                ans.add(0,arr);
            }

            return ans ;

        }
}

