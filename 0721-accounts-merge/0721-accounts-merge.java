class Solution {
    class DSU{
        int[] parent;
        DSU(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        public void union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa != pb){
                parent[pb] = pa;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU obj = new DSU(n);

        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            List<String> acc = accounts.get(i);
            for(int j = 1; j < acc.size(); j++){
                String email = acc.get(j);
                
                if(!map.containsKey(email)){
                    map.put(email,i);
                }
                else{
                    obj.union(i,map.get(email));
                    }
                }
            }

            HashMap<Integer,List<String>> list = new HashMap<>();

            ArrayList<String> emailKeys = new ArrayList<>(map.keySet());
            for(int i = 0; i < emailKeys.size(); i++){

                String email = emailKeys.get(i);

                int parent = obj.find(map.get(email));
                list.putIfAbsent(parent,new ArrayList<>());
                list.get(parent).add(email);
            }

            List<List<String>> result = new ArrayList<>();

            ArrayList<Integer> mergedKeys = new ArrayList<>(list.keySet());
            for(int i = 0; i < mergedKeys.size(); i++){

                int key = mergedKeys.get(i);

            List<String> emails = list.get(key);
            Collections.sort(emails);
            List<String> temp = new ArrayList<>();

            temp.add(accounts.get(key).get(0));
            temp.addAll(emails);

            result.add(temp);
        }
        return result;
    }
}