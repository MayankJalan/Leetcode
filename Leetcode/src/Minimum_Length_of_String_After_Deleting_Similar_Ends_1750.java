public class Minimum_Length_of_String_After_Deleting_Similar_Ends_1750 {
    public int minimumLength(String s) {
        int n=s.length();
        int left=0, right=n-1;

        while(left <right){
            if(s.charAt(left) ==  s.charAt(right)){
                do{
                    left ++;
                }while((left < right && s.charAt(left) == s.charAt(left-1)));
                if(left==right){
                    return 0;
                }
                else{
                    do{
                        right--;
                    } while(left <= right && s.charAt(right) == s.charAt(right+1));
                }
            }
            else{
                break;
            }
        }
        return right-left+1;
    }
}
