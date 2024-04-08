import java.util.HashMap;

public class NumberofStudentsUnabletoEatLunch_1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        HashMap<Integer,Integer> map=new HashMap<>();

        int n=students.length;

        for(int i=0;i<n;i++){
            map.put(students[i],map.getOrDefault(students[i], 0)+1);
        }
        int ans=n;
        for(int i : sandwiches ){
            if(map.get(i) != null){
                ans--;
                if(map.get(i) ==1){
                    map.remove(i);

                }
                else{
                    map.put(i, map.get(i)-1);
                }
            }
            else{
                return ans;
            }
        }

        return ans;

    }
}
