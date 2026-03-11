class Solution {
    class DSU{
        int parent[];
        DSU(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
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
    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n - 1) return -1;

        DSU obj = new DSU(n);

        for(int i = 0; i < connections.length; i++){

            int u = connections[i][0];
            int v = connections[i][1];

            obj.union(u,v);
        }
        int comp = 0;

        for(int i = 0; i < n; i ++){
            if(obj.find(i) == i) comp++;
        }
        return comp - 1;

    
    }
}