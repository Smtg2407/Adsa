class Solution {

    public int solve(int points[],int i, int[] dp, boolean[] visited){

        if(i <= 0) return 0;

        if(visited[i]) return dp[i];

        int skip = solve(points, i - 1, dp, visited);
        int take = points[i] + solve(points, i -2, dp, visited);

        dp[i] = Math.max(skip, take);
        visited[i] = true;

        return dp[i];

    }

    public int deleteAndEarn(int[] nums) {

        int max = 0;

        for(int i = 0;i< nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        int[] points = new int[max + 1];

        for(int i = 0;i < nums.length; i++){
            points[nums[i]] += nums[i];
        }

        int[] dp = new int[max + 1];
        boolean visited[] = new boolean[max + 1];

        return solve(points, max, dp, visited);
    }
}