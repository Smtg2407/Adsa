class Solution {
    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    int rowDirection[] = {1,-1,0,0};
    int colDirection[] = {0,0,1,-1};

    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            Pair curr = q.poll();

            int r = curr.row;
            int c = curr.col;

            for(int i = 0; i < 4; i++){
                int newRow = r + rowDirection[i];
                int newCol = c + colDirection[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]){

                    dist[newRow][newCol] = dist[r][c] + 1;
                    visited[newRow][newCol] = true;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
        return dist;
        
    }
}