class Solution {
    public int findLengthOfLCIS(int[] nums) {

        int curr = 1;
        int maxLen = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                curr++;
            }else{
                curr = 1;
            }
            maxLen = Math.max(maxLen, curr);
        }
        return maxLen;
    }
}