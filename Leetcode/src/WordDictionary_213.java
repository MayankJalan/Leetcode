class WordDictionary_213 {
    Node node;

    public WordDictionary_213() {
        node =new Node();
    }

    public void addWord(String word) {
        Node curr=node;
        for(char ch : word.toCharArray()){
            if(!curr.containsKey(ch)){
                curr.put(new Node(),ch);
            }
            curr=curr.get(ch);
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        Node curr=node;
        return dfs(curr,word);


    }

    private boolean dfs(Node curr, String word) {
        if(word.length()==0){
            return curr.isEnd;
        }
        char ch =word.charAt(0);
        if(ch!='.'){
            if(curr.containsKey(ch)){
                curr=curr.get(ch);
                return dfs(curr,word.substring(1));
            }
            else{
                return false;
            }
        }
        else{
            for(int i=0;i<26;i++){
                char c =(char)('a'+i);
                if(curr.containsKey(c)){
                    if(dfs(curr.get(c), word.substring(1))){
                        return true;
                    }
                }
            }
        }
        return false;

    }
}

class Node{
    Node links[]=new Node[26];
    boolean isEnd=false;
    public Node get(char ch){
        return links[ch-'a'];
    }
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    public void put(Node node, char ch){
        links[ch-'a']=node;
    }

}
