import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpentheLock_752 {
    class Pair{
        String str;
        int steps;
        Pair(String str, int steps){
            this.steps=steps;
            this.str=str;
        }
    }
    public int openLock(String[] deadends, String target) {
        HashSet<String> map=new HashSet<>();
        Arrays.stream(deadends).forEach(s-> map.add(s));
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair("0000",0));

        while(!q.isEmpty()){
            Pair p=q.poll();
            if(p.str.equals(target)){
                return p.steps;
            }

            if(map.contains(p.str)){
                continue;
            }
            map.add(p.str);

            for(int i=0;i<4;i++){
                if(p.str.charAt(i)=='9'){
                    char temp[]=p.str.toCharArray();
                    temp[i]='0';
                    q.add(new Pair(String.valueOf(temp),p.steps+1));
                }
                else{
                    char temp[]=p.str.toCharArray();
                    temp[i]=(char)(p.str.charAt(i)+1);
                    q.add(new Pair(String.valueOf(temp),p.steps+1));
                }
                if(p.str.charAt(i)=='0'){
                    char temp[]=p.str.toCharArray();
                    temp[i]='9';
                    q.add(new Pair(String.valueOf(temp),p.steps+1));
                }
                else{
                    char temp[]=p.str.toCharArray();
                    temp[i]=(char)(p.str.charAt(i)-1);
                    q.add(new Pair(String.valueOf(temp),p.steps+1));
                }
            }

        }

        return -1;
    }
}
