import java.util.Arrays;

public class MaximumXORWithanElementFromArray {
    class Query{
        int x,max,index;
        Query(int x, int max, int index){
            this.x=x;
            this.max=max;
            this.index=index;
        }
    }
    class Node{
        Node [] links=new Node[2];

        private void put(Node node, int bit){
            links[bit]=node;
        }
        private Node get(int bit){
            return links[bit];
        }
        private boolean containsKey(int bit){
            return links[bit]!=null;
        }
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Node root=new Node();
        int m=queries.length;
        Query arr[]=new Query[m];
        for(int i=0;i<m;i++){
            arr[i]=new Query(queries[i][0], queries[i][1], i);
        }
        Arrays.sort(arr, (a, b) -> a.max-b.max);

        int ans[]=new int[m];
        Arrays.fill(ans,-1);
        int k=0;
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<m;i++){
            int x=arr[i].x;
            int max=arr[i].max;
            int index=arr[i].index;
            while(k<n && nums[k]<=max) {
                insertNumberintoTree(root, nums[k]);
                k++;
            }

            int maxXor= -1;
            if(k!=0){
                maxXor=findXor(root,x);
            }

            ans[index]=maxXor;
        }

        return ans;


    }
    private void insertNumberintoTree(Node root, int x){
        Node curr=root;
        for(int i=31;i>=0;i--){
            int bit=(x&(1<<i)) ==0 ?0 :1;
            if(!curr.containsKey(bit)){
                curr.put(new Node(), bit);
            }
            curr=curr.get(bit);
        }
    }

    private int findXor(Node root, int x){
        Node curr=root;
        int ans=0;
        for(int i=31;i>=0;i--){
            int bit=(x&(1<<i)) ==0 ?0 :1;
            if(curr.containsKey(1-bit)){
                ans=ans|(1<<i);
                curr=curr.get(1-bit);
            }
            else
                curr=curr.get(bit);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 4, 6, 6, 3};
        int[][] queries = {{12, 4}, {8, 1}, {6, 3}};
        int arr[]=new MaximumXORWithanElementFromArray().maximizeXor(nums,queries);
        System.out.println(Arrays.toString(arr));
    }


}
