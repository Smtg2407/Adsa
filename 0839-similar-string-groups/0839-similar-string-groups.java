class Solution {
    
    int parent[];

    public int find(int x){
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }
    public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa != pb){
            parent[pb] = pa;
        }
    }
    public boolean isSimilar(String a, String b){
        int diff = 0;

        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
                if(diff > 2) return false;
            }
        }
        return diff == 0 || diff == 2;
    }
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;

        parent = new int[n];

        for(int i = 0; i <n ;i++){
            parent[i] = i;
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(isSimilar(strs[i] , strs[j])){
                    union(i ,j);

                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(parent[i] == i) count++;
        }
        return count;
    }
}