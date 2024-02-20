import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] arr, int n) {
        Node trie=new Node();
        Node curr=trie;

        for(String str : arr){
            curr=trie;
            for(char ch : str.toCharArray()){
                if(!curr.containsKey(ch)){
                    curr.put(new Node(), ch);
                }
                curr=curr.get(ch);
                curr.increasePrefix();
            }
        }
        curr=trie;
        String ans="";

        for(char ch : arr[0].toCharArray()){
            if(curr.get(ch) !=null && curr.get(ch).countPrefix==n){
                ans+=String.valueOf(ch);
                curr=curr.get(ch);
            }
            else{
                return ans;
            }
        }
        return ans;


        // Write your code here
    }
    static class Node{
        Node links[]=new Node[26];
        int countPrefix=0;

        public Node get(char ch){
            return links[ch-'a'];
        }
        public void put(Node node, char ch){
            links[ch-'a']=node;
        }
        public boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
        public void increasePrefix(){
            countPrefix++;
        }
    }

    public static void main(String[] args) {
        String [] arr={"coding", "codezen", "codingninja", "coder"};
        longestCommonPrefix(arr,arr.length);
    }
}
