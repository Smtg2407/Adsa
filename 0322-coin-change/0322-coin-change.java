class Solution {
    public int solve(int amount, int[] coins, int [] dp){

        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;

        if(dp[amount] != -1) return dp[amount];

        int minCoins = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){

            int res = solve(amount - coins[i], coins, dp);;

            if(res != Integer.MAX_VALUE){
                minCoins = Math.min(minCoins, 1 + res);
            }
        }
        return dp[amount] = minCoins;
    }
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        for(int i =0; i <= amount; i++){
            dp[i] = -1;
        }
        int ans = solve(amount, coins, dp);

        if(ans == Integer.MAX_VALUE){
            return -1;
        }else{
            return ans;
        } 
        
    }
}