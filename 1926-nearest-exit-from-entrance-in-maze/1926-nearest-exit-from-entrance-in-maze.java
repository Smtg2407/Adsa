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
        if(row >= 0 && col >= 0 && row < totalRows && col < totalCols) return true;
        return false;
    }
    public int bfs(boolean isVisited[][], char[][] maze, int currRow, int currCol, int totalRows, int totalCols){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(currRow, currCol));
        isVisited[currRow][currCol] = true;

        int steps = 0;
        
        while(!q.isEmpty()){

            int size = q.size();
            steps++;

            for(int s = 0; s< size; s++){
                Pair curr = q.poll();

                for(int i = 0; i < 4; i++){
                    int newRow = curr.row + rowDirection[i];
                    int newCol = curr.col + colDirection[i];

                    if(isValid(newRow, newCol, totalRows, totalCols)
                    && !isVisited[newRow][newCol]
                    && maze[newRow][newCol] == '.') {
                        
                        if(newRow == 0 || newRow == totalRows - 1 || newCol == 0 || newCol == totalCols - 1){
                            return steps;
                        }
                        isVisited[newRow][newCol] = true;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }
        }
        return -1;
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        boolean[][] isVisited = new boolean[n][m];

        return bfs(isVisited, maze, entrance[0], entrance[1], n ,m);
        
    }
}