class Solution {
    static class DSU{
        int parent[];
        int rank[];
        DSU(int n){
            parent = new int[n+1];
            rank = new int[n+1];

            for(int i = 0; i <= n; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x] == x) return x;

            return parent[x] = find(parent[x]);
        }
        boolean union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb){
                return false;
            }
            if(rank[pa] < rank[pb]){
                parent[pa] = pb;
            }else if (rank[pb] < rank[pa]){
                parent[pb] = pa;
            }else{
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
            
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);

        int usedEdge = 0;

        for(int i = 0; i < edges.length; i++){
            int t = edges[i][0];
            int u = edges[i][1];
            int v = edges[i][2];

            if(t == 3){
                boolean a = alice.union(u,v);
                boolean b = bob.union(u,v);

                if(a | b){
                    usedEdge++;
                }
            }
        }
        for(int i = 0; i < edges.length; i++){

            int t = edges[i][0];
            int u = edges[i][1];
            int v = edges[i][2];

            if(t == 1){
                if(alice.union(u,v)){
                    usedEdge++;
                }
            }
        }
        for(int i = 0; i < edges.length; i++){
            int t = edges[i][0];
            int u = edges[i][1];
            int v = edges[i][2];

            if(t == 2){
                if(bob.union(u,v)){
                    usedEdge++;
                }
            }
        }
        int rootA = alice.find(1);
        int rootb = bob.find(1);

        for(int i = 2;i <= n; i++){
            if(alice.find(i) != rootA || bob.find(i) != rootb){
                return -1;
            }
        }
        return edges.length - usedEdge;


    }
}