class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        char[] color = new char[n];

        for(int i = 0; i< n; i++){
            color[i] = 'U';
        }

        for(int i = 0; i <n; i++){
            if(color[i] != 'U') continue;

            Queue<Integer> q = new LinkedList<>();

            q.add(i);
            color[i] = 'A';

            while(!q.isEmpty()){
                int curr = q.poll();

                for(int j = 0; j < graph[curr].length; j++){
                    int neigh = graph[curr][j];

                    if(color[neigh] == 'U'){
                        if(color[curr] == 'A') color[neigh] = 'B';
                        else
                        color[neigh] = 'A';
                        q.add(neigh);
                    }
                    else if(color[neigh] == color[curr]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}