class Solution {
    public int solve(int currRow, int currCol, int rows, int cols, int[][] dp,int [][]obstacleGrid){

        if(currRow >= rows || currCol >= cols) return 0;
        if(currRow == rows - 1 && currCol == cols - 1) return 1;

        if(dp[currRow][currCol] != 0) return dp[currRow][currCol];
        if(obstacleGrid[currRow][currCol] == 1) return 0;

        int rightWays = solve(currRow, currCol + 1, rows, cols, dp, obstacleGrid);
        int downWays = solve(currRow+1, currCol, rows, cols, dp, obstacleGrid);

        return dp[currRow][currCol] = rightWays + downWays;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if(obstacleGrid[n-1][m-1] == 1) return 0;

        int dp[][] = new int[n][m];
        int ans = solve(0,0,n,m,dp,obstacleGrid);
        return ans;
        
    }
}