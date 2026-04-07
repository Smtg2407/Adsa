class Solution {
    public int solve(int currRow, int currCol, int rows, int cols, int dp[][]){

        if(currRow >= rows|| currCol >= cols) return 0;
        if(currRow == rows - 1 && currCol == cols - 1) return 1;
        if(dp[currRow][currCol] != 0) return dp[currRow][currCol];


        int rightWays = solve(currRow, currCol+1,rows, cols,dp);
        int downWays = solve(currRow+1, currCol, rows, cols,dp);

        return dp[currRow][currCol] = rightWays + downWays;
    }
    public int uniquePaths(int m, int n) {
        int dp [][] = new int[m][n];

        int ans =  solve(0,0,m,n,dp);
        return ans;
    
    }
}