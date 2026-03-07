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

    public boolean isValid(int row, int col, int totalRows, int totalCols){
        return row>= 0 && row < totalRows && col >= 0 &&  col < totalCols;
        
    }



    public boolean bfs(boolean[][] visited,int[][] grid, int currRow, int currCol, int totalRows, int totalCols){
        Queue <Pair> q = new LinkedList<>();

        
        q.add(new Pair(currRow, currCol));
        visited[currRow][currCol] = true;

        boolean isClosed = true;

        while(!q.isEmpty()){

            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;

            if(r == 0 ||r == totalRows - 1 ||
            c == 0 || c == totalCols - 1){
            isClosed = false;
            }

            for(int i = 0; i < 4; i++){

                int newRow = r + rowDirection[i];
                int newCol = c + colDirection[i];

                if (isValid(newRow, newCol, totalRows, totalCols) &&
                    grid[newRow][newCol] == 0 &&
                    !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    q.add(new Pair(newRow, newCol));


                }
            }
        }
        return isClosed;
    }
    public int closedIsland(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0 && !visited[i][j]) {
                    if(bfs(visited, grid, i, j,  n, m)){
                        count++;
                    }
                    
                }
            }
        }
        return count;
    }
}