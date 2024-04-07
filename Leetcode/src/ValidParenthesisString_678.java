import java.util.Stack;

public class ValidParenthesisString_678 {
    public boolean checkValidString(String s) {
        Stack<Integer> stk=new Stack<>();
        Stack<Integer> star=new Stack<>();
        for(int i=0;i<s.length(); i++){
            char ch =s.charAt(i);
            if(ch=='('){
                stk.push(i);
            }
            else if(ch==')'){
                if(!stk.isEmpty()){
                    stk.pop();
                }
                else if(!star.isEmpty()){
                    star.pop();
                }
                else{
                    return false;
                }
            }
            else{
                star.push(i);
            }
        }
        while(!stk.isEmpty() && !star.isEmpty() ){
            if(stk.peek()>star.peek()){
                return false;
            }
            stk.pop();
            star.pop();
        }

        return stk.isEmpty();
    }
}
