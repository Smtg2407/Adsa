class Solution {
    int[] parent;

    public int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
        
    }
    public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa != pb) {
            parent[pb] = pa;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];

        for(int i = 0; i < n; i++)
            parent[i] = i;
        
        int count = n;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n ; j++){

                if(isConnected[i][j] == 1){
                    int pa = find(i);
                    int pb = find(j);

                    if(pa != pb){
                        union(pa, pb);
                        count--;
                    }
                }
            }
        }
        return count;

    }
}