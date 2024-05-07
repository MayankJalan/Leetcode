import java.util.*;

public class AccountsMerge_721 {
    class Disjoint{
        int parent[];
        int size[];
        Disjoint(int n) {
            parent=new int[n];
            size=new int[n];
            for (int i = 0; i < n; i++) {
                parent[i]=i;
                size[i]=1;
            }
        }


        public int findParent(int i){
            if(parent[i]==i){
                return i;
            }
            int uniParent=findParent(parent[i]);
            parent[i]=uniParent;
            return uniParent;
        }

        public void unionBySize(int u, int v){
            int uniU=findParent(u);
            int uniV=findParent(v);
            if(uniU==uniV){
                return;
            }
            if(size[uniU]>size[uniV]){
                parent[uniV]=parent[uniU];
                size[uniU]+=size[uniV];
            }
            else{
                parent[uniU]=parent[uniV];
                size[uniV]+=size[uniU];
            }
        }


    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        HashMap<String,Integer> map=new HashMap<>();
        Disjoint ds=new Disjoint(n);
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(map.containsKey(mail)){
                    ds.unionBySize(i,map.get(mail));
                }
                else{
                    map.put(mail,i);
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<String>();

        List<List<String>> ans = new ArrayList<>();


        for(Map.Entry<String,Integer> ent : map.entrySet()){
            mergedMail[ds.findParent(ent.getValue())].add(ent.getKey());
        }

        for(int i=0;i<n;i++){
            if(mergedMail[i].size()==0){
                continue;
            }
            ArrayList<String>  temp=new ArrayList(mergedMail[i]);
            Collections.sort(temp);
            temp.add(0,accounts.get(i).get(0));
            ans.add(temp);
        }

        return ans;

    }
}
