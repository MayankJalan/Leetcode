class MagicDictionary_676 {
    Node root;

    public MagicDictionary_676() {
        root=new Node();


    }
    public void buildDict(String[] dictionary) {
        for(String word : dictionary){
            Node curr=root;
            for(char ch : word.toCharArray()){
                if(!curr.containsKey(ch)){
                    curr.put(new Node(),ch);
                }
                curr=curr.get(ch);
            }
            curr.isEnd=true;
        }
    }

    public boolean search(String searchWord) {
        Node curr=root;
        return dfs(searchWord, curr, 0);
    }

    private boolean dfs(String searchWord , Node curr, int count){
        if(count>1){
            return false;
        }
        if(searchWord.length()==0){
            if(count==1 && curr.isEnd)
                return true;
            return false;

        }
        char ch =searchWord.charAt(0);

        for(int i=0;i<26;i++){
            char c= (char) (i+'a');
            if(curr.containsKey(c)){
                if(c==ch){
                    if(dfs(searchWord.substring(1),curr.get(c),count)){
                        return true;
                    }
                }
                else{
                    if(count+1>1){
                        continue;
                    }
                    else if(dfs(searchWord.substring(1),curr.get(c),count+1)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {

        String dict[]={"hello","leetcode"};
        MagicDictionary_676 magicDictionary676=new MagicDictionary_676();
        magicDictionary676.buildDict(dict);
        System.out.println(magicDictionary676.search("hello"));



    }
}
