class Solution {
    class DSU{
        int parent[];

        DSU(int n){
            parent = new int[n + 1];

            for(int i = 0; i <= n; i++){
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

            if(pa != pb){
                parent[pa] = pb;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU obj = new DSU(n);

        for(int i = 0; i < edges.length; i++){

            int u = edges[i][0];
            int v = edges[i][1];

            if(obj.find(u) == obj.find(v)){
                return edges[i];
            }
            obj.union(u, v);
        }
        return new int[0];
    }
}


