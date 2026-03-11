class Solution {
    public boolean xorGame(int[] nums) {
        
        int xor = 0;

        for(int i = 0; i < nums.length; i++){
            xor ^= nums[i];
        }
        if(xor == 0) return true;

        return nums.length % 2 == 0;
    }
}