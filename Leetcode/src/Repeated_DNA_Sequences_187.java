import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Repeated_DNA_Sequences_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> map=new HashMap<>();

        List<String> ans=new ArrayList<>();
        int n=s.length();
        for(int i=0;i<=n-10;i++){
            String str=s.substring(i,i+10);
            if(map.containsKey(str)){
                int val= map.get(str);
                if(val==1){
                    ans.add(str);
                }
                map.put(str,val+1);
            }
            else
                map.put(str, 1);
        }
        return ans;
    }
}
