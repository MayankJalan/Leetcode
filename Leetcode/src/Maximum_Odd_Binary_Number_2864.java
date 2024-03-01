public class Maximum_Odd_Binary_Number_2864 {
    public String maximumOddBinaryNumber(String s) {
        int count=0;
        for(char ch : s.toCharArray()){
            if(ch=='1'){
                count++;
            }
        }
        StringBuffer sb=new StringBuffer("");
        while(count>1){
            sb.append("1");
            count--;
        }
        while(sb.length() != s.length()-1){
            sb.append("0");
        }
        if(count==1){
            sb.append("1");
        }
        else{
            sb.append("0");
        }

        return String.valueOf(sb);

    }
}
