class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 0;
        int lastIndex = 1;

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            if(dp[i] >  maxLen){
                maxLen = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int currLen = maxLen;
        int currNum = nums[lastIndex];

        for(int i = lastIndex; i >= 0; i--){
            if(currNum % nums[i] == 0 && dp[i] == currLen){
                ans.add(nums[i]);
                currNum = nums[i];
                currLen--;
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}