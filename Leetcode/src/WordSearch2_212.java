import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearch2_212 {
    Node root=new Node();
    public List<String> findWords(char[][] board, String[] words) {

        List<String> ans=new ArrayList<>();
        Arrays.stream(words).forEach(w -> insert(w));

        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(root.containsKey(board[i][j])){
                    dfs(root, i, j, n, m, new boolean[n][m],ans ,board);
                }
            }
        }

        return ans;

    }

    private void dfs(Node curr, int i, int j, int n,int  m, boolean vis[][], List<String> ans,char[][] board ){

        if(i<0 || j< 0 || i>=n || j >= m || vis[i][j] || !curr.containsKey(board[i][j]) ){
            return ;
        }
        curr=curr.get(board[i][j]);
        if(curr.containsWord()){
            ans.add(curr.getWord());
            curr.setWord(null);
        }

        vis[i][j]=true;
        dfs(curr,i+1,j,n,m,vis,ans,board);
        dfs(curr,i-1,j,n,m,vis,ans,board);
        dfs(curr,i,j+1,n,m,vis,ans,board);
        dfs(curr,i,j-1,n,m,vis,ans,board);
        vis[i][j]=false;




    }

    private void insert(String word) {

        Node curr=root;
        for(char ch : word.toCharArray()){
            if(!curr.containsKey(ch)){
                curr.put(new Node(), ch);
            }
            curr=curr.get(ch);
        }
        curr.setWord(word);
    }
    class Node{
        Node links[]=new Node[26];
        String word=null;
        public Node get(char ch){
            return links[ch-'a'];
        }
        public boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
        public void put(Node node, char ch){
            links[ch-'a']=node;
        }
        public boolean  containsWord(){
            return word != null && word.length() > 0 ;
        }
        public String  getWord(){
            return this.word;
        }
        public void  setWord(String word){
            this.word=word;
        }
    }
}

