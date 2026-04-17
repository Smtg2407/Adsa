class Solution {
    public int solve(int currRow, int currCol, int row, int col, int[][] dp){
        if(currRow >= row || currCol >= col) return 0;
        if(currRow == row - 1 && currCol == col - 1) return 1;

        if(dp[currRow][currCol] != 0) return dp[currRow][currCol];

        int right = solve(currRow, currCol + 1, row, col, dp);
        int down = solve(currRow + 1, currCol, row, col, dp);

        return dp[currRow][currCol] = right + down;
    }
    
    public int uniquePaths(int m, int n) { 
        int[][] dp = new int[m][n];

        return solve(0,0,m,n,dp);
    }
}