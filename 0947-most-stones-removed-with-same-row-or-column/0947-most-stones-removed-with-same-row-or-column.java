class Solution {
    class DSU{
        int parent[];
        DSU(int n){
            parent = new int[n];

            for(int i = 0; i < n ; i++){
                parent[i] = i;
            }
        }
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
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;

        DSU obj = new DSU(n);
        for(int i = 0; i <n;i++){
            for(int j = i + 1; j < n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    obj.union(i,j);
                }
            }
        }
        int com = 0;
        for(int i = 0; i < n; i++){
            if(obj.find(i) == i){
                com++;
            }
        }
        return n -  com;
        
    }
}