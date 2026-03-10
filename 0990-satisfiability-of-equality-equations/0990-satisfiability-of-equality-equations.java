class Solution {
    class DSU{
        int parent[];
        int rank[];

        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i <n ;i++){
                parent[i] = i;
            }
        }
        public int find(int x){
             if(parent[x] == x) return x;
           return parent[x] = find(parent[x]);
        }

        public void union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa != pb) {
                if(rank[pa] > rank[pb]){
                    parent[pb] = pa;
                }else if(rank[pb] > rank[pa]){
                    parent[pa] = pb;
                }else{
                    parent[pb] = pa;
                    rank[pa]++;
                }
            }

        }
    }
    public boolean equationsPossible(String[] equations) {
        DSU obj = new DSU(26);

        for(int i = 0; i < equations.length; i++){
            String eq = equations[i];

            if(eq.charAt(1) == '='){
                int a = eq.charAt(0) - 'a';
                int b = eq.charAt(3) - 'a';

                obj.union(a, b);
            }
        }
        for(int i = 0; i < equations.length; i++){
            String eq = equations[i];

            if(eq.charAt(1) == '!'){
                int a = eq.charAt(0) - 'a';
                int b = eq.charAt(3) - 'a';

                int pa = obj.find(a);
                int pb = obj.find(b);

                if(pa == pb) return false;

            }
           
        }
        return true;
    }
}