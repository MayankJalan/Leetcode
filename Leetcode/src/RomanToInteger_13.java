import java.util.HashMap;

public class RomanToInteger_13 {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n=s.length();



        char prev=s.charAt(n-1);
        int ans=map.get(prev);

        for(int i=n-2;i>=0;i--){
            char curr=s.charAt(i);
            if(map.get(prev)>map.get(curr)){
                ans=ans-map.get(curr);
            }
            else{
                ans=ans+map.get(curr);
            }
            prev=curr;
        }

        return ans;



    }
}
