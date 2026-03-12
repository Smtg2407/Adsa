class Solution {

    int parent[];
    int rank[];

    public int find(int x){
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }
    public boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return true;

        if(rank[pa]  < rank[pb]) parent[pa] = pb;
        else if(parent[pa] > rank[pb]) parent[pb] = pa;
        else{
            parent[pb] = pa;
            rank[pa]++;
        
        }
        return false;
    }
        
    public boolean containsCycle(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        parent = new int[n*m];
        rank = new int[n*m];

        for(int i=0;i<n*m;i++){
            parent[i] = i;
        }
        

        for(int i = 0; i <n ; i++){
            for(int j = 0; j < m ; j++){

                int node = i * m + j;

                if(j + 1 < m && grid[i][j] == grid[i][j + 1]){
                    int neigh = i * m + (j + 1);

                    if(union(node, neigh)) return true;
                }
                if(i + 1 < n && grid[i][j] == grid[i + 1][j]){
                    int neigh = (i+1)*m + j;
                    if(union(node, neigh)) return true;
                }
            }
       }   
        return false;
    }
}