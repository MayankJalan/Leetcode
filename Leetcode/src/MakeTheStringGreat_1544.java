import java.util.Stack;

public class MakeTheStringGreat_1544 {
    public String makeGood(String s) {
        int n=s.length();
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<n;i++){
            char ch =s.charAt(i);

            if(!stk.isEmpty() && Character.toLowerCase(ch) == Character.toLowerCase(stk.peek()) &&  ((Character.isUpperCase(ch) && Character.isLowerCase(stk.peek())) || (Character.isUpperCase(stk.peek()) && Character.isLowerCase(ch)))){
                stk.pop();
            }
            else{
                stk.push(ch);
            }

        }
        StringBuffer str=new StringBuffer("");
        while(!stk.isEmpty()){
            str.append(stk.pop());
        }

        return str.reverse().toString();
    }
}
