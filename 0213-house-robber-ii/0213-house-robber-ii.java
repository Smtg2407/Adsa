class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n < 2) return nums[0];

        int[] skipLastHouse = new int[n - 1];
        int[] skipFirstHouse = new int[n - 1];

        for(int i = 0; i < n - 1; i++) {
            skipLastHouse[i] = nums[i];
            skipFirstHouse[i] = nums[i + 1];
        }
        
        int lootSkippingLast = robHelper(skipLastHouse);
        int lootSkippingFirst = robHelper(skipFirstHouse);

        return Math.max(lootSkippingLast ,lootSkippingFirst);
    }
    public int robHelper(int[] nums){

        int n = nums.length;

        if(n < 2) return nums[0];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i] , dp[i - 1]);
        }
        return dp[n - 1];
                                                                                    
    }
}

