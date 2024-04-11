public class ExcelSheetColumnNumber_171 {
    public int titleToNumber(String columnTitle) {
        int n=columnTitle.length() , ans=0;
        for(int i=n-1;i>=0;i--){
            char ch=columnTitle.charAt(i);
            ans+=Math.pow(26,n-i-1)*(ch-'A'+1);
        }

        return ans;

    }
}
