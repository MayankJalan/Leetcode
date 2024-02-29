import java.util.LinkedList;
import java.util.Queue;

public class Even_Odd_Tree_1609 {
    public boolean isEvenOddTree(TreeNode root) {
        int level=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int n=q.size();
            int prev=-1;
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();

                if(i == 0){
                    if((level % 2 == 0 && curr.val % 2 == 1)
                            || (level % 2 == 1 && curr.val % 2 == 0)
                    ){
                        prev = curr.val;

                    }else{
                        return false;
                    }
                }
                else{
                    if(level%2==0){
                        if(curr.val%2==0 || curr.val<=prev){
                            return false;
                        }
                        else{
                            prev=curr.val;
                        }

                    }
                    else{
                        if(curr.val%2!=0 || curr.val>=prev){
                            return false;
                        }
                        else{
                            prev=curr.val;
                        }

                    }
                }
                if(curr.left !=null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }

            }
            level++;
        }
        return true;

    }
}
