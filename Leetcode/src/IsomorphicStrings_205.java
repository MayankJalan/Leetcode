import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        int n=s.length();
        if(t.length() != n){
            return false;
        }
        HashMap<Character,Character> map=new HashMap<>();
        HashSet<Character> set =new HashSet<>();

        for(int i=0;i<n;i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);

            if(map.containsKey(ch1)){
                if(ch2 != map.get(s.charAt(i))){
                    return false;
                }
            }
            else{
                if(set.contains(ch2)){
                    return false;
                }
                set.add(ch2);
                map.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;

    }
    public static void main(String[] args) {
        String s="paper";
        String t="title";
        new IsomorphicStrings_205().isIsomorphic(s,t);
    }
}
