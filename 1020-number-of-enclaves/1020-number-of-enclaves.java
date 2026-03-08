class Solution {

    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    int rowDirection [] = {1,-1,0,0};
    int colDirection [] = {0,0,1,-1};

    public boolean isValid(int row, int col, int totalRows, int totalCols){
        if(row>=0 && row< totalRows && col >= 0 && col < totalCols) return true;
        return false;
    }
    public void bfs(int[][] grid, int currRow, int currCol, int totalRows, int totalCols){
        Queue<Pair> q = new LinkedList<>();

        Pair p = new Pair(currRow, currCol);
        q.add(p);
        grid[currRow][currCol] = 0;

        while(!q.isEmpty()){
            Pair curr = q.poll();

            int currPairRow = curr.row;
            int currPairCol = curr.col;

            for(int i = 0; i < 4; i++){

                int newRow = currPairRow + rowDirection[i];
                int newCol = currPairCol + colDirection[i];

                if (isValid(newRow, newCol, totalRows, totalCols) &&
                    grid[newRow][newCol] == 1) {

                    grid[newRow][newCol] = 0;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++ ){
            if (grid[i][0] == 1)
                bfs(grid, i, 0, n, m);

            if (grid[i][m - 1] == 1)
                bfs(grid,i, m - 1, n, m);    
        }

        for (int j = 0; j < m; j++) {

            if (grid[0][j] == 1)
                bfs(grid, 0, j, n, m);

            if (grid[n - 1][j] == 1)
                bfs(grid, n - 1, j, n, m);
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
            if(grid[i][j] == 1){
                count++;

            }
        }
        return count;



        
    }
}