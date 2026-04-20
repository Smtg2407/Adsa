class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;

        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
        }

        if((totalSum + target) % 2 != 0 || Math.abs(target) > totalSum){
            return 0;
        }

        int sum = (totalSum + target) / 2;

        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for(int i = 0; i < nums.length; i++){
            for(int j = sum; j >= nums[i]; j--){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[sum];


    }
}