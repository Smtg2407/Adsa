class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for(int i = 0; i < nums.length; i++){
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        int ans = high;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isPossible(nums, k, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[] nums,int k, int maxSum){
        int subArray = 1;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            if(sum + nums[i] > maxSum){
                subArray++;
                sum = nums[i];
            }else{
                sum += nums[i];
            }
        }
        return subArray <= k;
    }
}