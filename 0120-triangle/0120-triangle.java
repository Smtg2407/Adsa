class Solution {
    public int solve(int row, int col, List<List<Integer>> triangle, Integer[][] dp){
        int n = triangle.size();

        if(row == n - 1) return triangle.get(row).get(col);
        if(dp[row][col] != null) return dp[row][col];

        int downWays = solve(row + 1, col, triangle, dp);
        int diagnolWays = solve(row+1, col+1,triangle, dp);

        return dp[row][col] = triangle.get(row).get(col) + Math.min(downWays, diagnolWays);
    }
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return solve(0,0,triangle, dp);
    }
}