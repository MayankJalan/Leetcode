public class ShortestandLexicographicallySmallestBeautifulString_2904 {
    public String shortestBeautifulSubstring(String s, int k) {
        int left=0,right=0;
        int n=s.length();
        int count=0;
        String ans="";
        while(right<n){
            if(s.charAt(right)=='1'){
                count++;
            }
            while(count>k){
                if(s.charAt(left)=='1'){
                    count--;
                }
                left++;
            }
            while(count==k && s.charAt(left) =='0'){
                left++;
            }
            if(count==k){
                String str=s.substring(left,right+1);
                if(ans.isEmpty() || (str.length()< ans.length()) ||  (str.length() == ans.length() && str.compareTo(ans)<0) ){
                    ans=str;
                }

            }
            right++;
        }

        return ans;

    }
}
