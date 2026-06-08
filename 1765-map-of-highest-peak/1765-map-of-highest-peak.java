class Solution {
    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    int rowDir[] = {1,-1,0,0};
    int colDir[] = {0,0,1,-1};

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean visited[][] = new boolean[m][n];
        int dist[][] = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int currRow = curr.row;
            int currCol = curr.col;

            for(int i = 0; i < 4; i++){
                int newRow = currRow + rowDir[i];
                int newCol = currCol + colDir[i];

                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]){
                    dist[newRow][newCol] = dist[currRow][currCol] + 1;
                    visited[newRow][newCol] = true;
                    q.add(new Pair(newRow, newCol));
                }
            }

        }
        return dist;

        
    }
}