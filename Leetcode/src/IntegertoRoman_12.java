public class IntegertoRoman_12 {
    public String intToRoman(int num) {
        String thousand[]={"M","MM","MMM","MMMM"};
        String hundreds[]={"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String tens[]={"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String ones[]={"I","II","III","IV","V","VI","VII","VIII","IX"};

        StringBuffer sb=new StringBuffer("");
        if(num/1000 !=0){
            int n=num/1000;
            sb.append(thousand[n-1]);
            num%=1000;
        }
        if(num/100 !=0){
            int n=num/100;
            sb.append(hundreds[n-1]);
            num%=100;
        }
        if(num/10 !=0){
            int n=num/10;
            sb.append(tens[n-1]);
            num%=10;
        }
        if(num !=0){
            int n=num;
            sb.append(ones[n-1]);
            num%=10;
        }
        return String.valueOf(sb);

    }
}
