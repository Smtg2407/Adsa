class Solution {
    int parent[];
   
    public int find(int x){
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }
    public boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb){
            return false;               
        }
        parent[pb] = pa;
        return true;
    }
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;

        int parentCheck[] = new int[n + 1];
        int first[] = null;
        int second[] = null;

        for(int i = 0; i < edges.length; i++){

            int u = edges[i][0];
            int v = edges[i][1];

            if(parentCheck[v] == 0){
                parentCheck[v] = u;
            }
            else{
                first = new int[]{parentCheck[v], v};
                second = new int[]{u, v};

                edges[i][1] = 0; 
            }
        }

        parent = new int[n + 1];

        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(v == 0){
                continue;
            }
            if(!union( u, v)){
                if(first == null){
                    return edges[i];
                }

                return first;
            }
        }
        return second;
    }
}