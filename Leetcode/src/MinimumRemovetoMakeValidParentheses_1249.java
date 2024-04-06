import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses_1249 {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk=new Stack();
        int n =s.length();
        for(int i=0;i<n;i++){
            char ch= s.charAt(i);
            if(ch=='('){
                stk.push(i);
            }
            else if(ch==')'){
                if(stk.isEmpty() || s.charAt(stk.peek())==')'){
                    stk.push(i);
                }
                else{
                    stk.pop();
                }
            }
        }
        String str="";
        for(int i=n-1;i>=0;i--){
            if(!stk.isEmpty() && stk.peek()==i){
                stk.pop();
            }
            else{
                str=s.charAt(i)+str;
            }

        }
        return str;
    }
}
