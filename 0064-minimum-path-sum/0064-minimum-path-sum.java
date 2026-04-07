class Solution {
    public int solve(int currRow, int currCol, int row, int col, int[][] dp, int[][] grid){
        if(currRow >= row || currCol >= col) return Integer.MAX_VALUE;
        if(currRow == row - 1 && currCol == col - 1) return grid[currRow][currCol];

        if(dp[currRow][currCol] != -1) return dp[currRow][currCol];

        int rightWays = solve(currRow, currCol + 1, row, col, dp, grid);
        int downWays  = solve(currRow + 1, currCol, row, col, dp, grid);

        return dp[currRow][currCol] = grid[currRow][currCol] + Math.min(rightWays, downWays);


    }
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = solve(0,0,m,n, dp, grid);
        return ans;
    }
}