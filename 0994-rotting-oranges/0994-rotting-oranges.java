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
        if(row >= 0 && row < totalRows && col >= 0 && col < totalCols) return true;
        return false;
    }
    public int orangesRotting(int[][] grid) {
        
        Queue<Pair> q = new LinkedList<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int fresh = 0;

        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }else if(grid[i][j] == 1)  fresh++;
            }
        }
        int minutes = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            boolean flag = false;

            while(size != 0) {
                size--;

                Pair curr = q.poll();

                int currRow = curr.row;
                int currCol = curr.col;

                for(int i = 0; i < 4; i++){
                    int newRow = currRow + rowDirection[i];
                    int newCol = currCol + colDirection[i];

                    if(isValid(newRow, newCol, grid.length, grid[0].length) && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                        flag = true;
                        fresh--;
                        q.add(new Pair(newRow, newCol));
                        visited[newRow][newCol] = true;
                    }
                }
            }
            if(flag == true) minutes++;
        }
        if(fresh != 0) return -1;
        return minutes;
    }
}