class Solution {
    public int solve(int curr, int n,int cost[]) {
        
        if(curr >= n) return 0;

        int currCost = cost[curr];

        int leftChoice = solve(curr+1, n , cost);
        int rightChoice = solve(curr+2, n , cost);

        return currCost + Math.min(leftChoice, rightChoice);
    }

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(solve(0,cost.length,cost),solve(1,cost.length,cost));
    }
}