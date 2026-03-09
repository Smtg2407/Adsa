class Solution {
    int[] parent;

    public int find(int x){
        if(parent[x] == x){
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
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < edges.length; i++){

            int u = edges[i][0];
            int v = edges[i][1];

            if(find(u) == find(v)){
                return edges[i];
            }
            union(u, v);
        }
        return new int[0];
    }
}


