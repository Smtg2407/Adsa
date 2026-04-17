class Solution {
    public boolean solve(int i, int target, int[] nums, Boolean[][] dp){

        if(target == 0) return true;
        if(i == 0) return nums[0] == target;

        if(dp[i][target] != null) return dp[i][target];

        boolean notTake = solve(i - 1, target, nums, dp);
        boolean take = false;

        if(nums[i] <= target){
            take = solve(i - 1, target - nums[i], nums, dp);
        }
        return dp[i][target] = take || notTake;
    }
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int i = 0; i < nums.length ; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;

        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return solve(nums.length - 1, target, nums, dp);

        
    }
}