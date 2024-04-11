import java.util.Stack;

public class RemoveKDigits_402 {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk=new Stack<>();
        if(num.length() <=k ){
            return "0";
        }
        for(char ch : num.toCharArray() ){

            while(!stk.isEmpty() && k>0 && stk.peek() > ch){
                stk.pop();
                k--;
            }
            stk.push(ch);
        }
        while(!stk.isEmpty() && k>0){
            stk.pop();
            k--;
        }
        StringBuffer str=new StringBuffer("");
        for(char ch : stk){
            str.append(ch);
        }
        int i=0;
        for( i=0;i<str.length() ; i++){
            if(str.charAt(i)!='0'){
                break;
            }
        }

        String ans=str.toString().substring(i);
        return ans.isEmpty() ? "0" : ans;



    }
}
