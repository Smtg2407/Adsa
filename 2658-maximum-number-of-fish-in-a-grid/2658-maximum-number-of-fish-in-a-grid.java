class Solution {
    public int findMaxFish(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxSum = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] > 0){
                    int fish = dfs(grid, i, j);
                    maxSum = Math.max(maxSum , fish);
                }
            }
        }
        return maxSum;
    }
    public int dfs(int[][] grid , int r,int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }
        int fish = grid[r][c];
        grid[r][c] = 0;

        fish += dfs(grid, r + 1, c);
        fish += dfs(grid, r - 1, c);
        fish += dfs(grid, r, c + 1);
        fish += dfs(grid, r, c - 1);

        return fish;
    }
}