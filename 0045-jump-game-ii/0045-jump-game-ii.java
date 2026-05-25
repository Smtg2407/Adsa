class Solution {
    public int jump(int[] nums) {

        int n = nums.length;
        int count = 0;
        int curr = 0;
        int farthest = 0;

        for(int i = 0; i< nums.length - 1; i++){
            farthest = Math.max(farthest , i + nums[i]);

            if(farthest >= n - 1){
                return count + 1;
            }
            if(i == curr){
                if(i == farthest){
                    return -1;
                }else{
                    count++;
                    curr = farthest;
                }

            }
        }
        return 0;

        
    }
}