class Solution {
    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public boolean isValid(int row, int col, int totalRows, int totalCols){
        if(row >= 0 && col >= 0 && row < totalRows && col < totalCols) return true;
        return false;
    }

    int[] rowDir = {1,-1,0,0};
    int[] colDir = {0,0,1,-1};

    public void bfs(boolean visited[][], char [][] grid, int currRow, int currCol, int totalRows, int totalCols){

        Queue<Pair> q = new LinkedList<>();

        Pair p = new Pair(currRow, currCol);
        q.add(p);
        visited[currRow][currCol] = true;

        while(!q.isEmpty()){

            Pair curr = q.poll();

            int currPairRow = curr.row;
            int currPairCol = curr.col;

            for(int i = 0; i < 4; i++){
                int newRow = currPairRow + rowDir[i];
                int newCol = currPairCol + colDir[i];

                if(isValid(newRow, newCol, totalRows, totalCols) && grid[newRow][newCol] == '1' && visited[newRow][newCol] == false){
                    visited[newRow][newCol] = true;
                    q.add(new Pair(newRow, newCol));
                }

            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(grid[i][j] == '1' && visited[i][j] == false){
                    
                    bfs(visited,grid, i, j , n ,m);
                    count++;
                }
            }
        }
        return count;
        
    }
}