import java.util.HashMap;

public class CustomSortString_791 {
    public String customSortString(String order, String s) {

        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<order.length(); i++){
            map.put(order.charAt(i), i);
        }
        StringBuffer sb=new StringBuffer("");
        for(int i=0;i<s.length(); i++){
            char ch =s.charAt(i);
            if(!map.containsKey(ch)){
                sb.append(ch);
                continue;
            }
            int j=0;
            for(;j<sb.length();j++){
                char curr=sb.charAt(j);
                if(map.containsKey(curr) && map.get(curr)>map.get(ch)){
                    break;
                }
            }
            sb.insert(j,ch);
        }
        System.out.println(sb);
        return String.valueOf(sb);

    }
}
