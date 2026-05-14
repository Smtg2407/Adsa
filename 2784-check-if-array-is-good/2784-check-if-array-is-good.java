class Solution {
    public boolean isGood(int[] nums) {

        if(nums.length == 1) return false;

        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for(int i = 1; i < n; i++){
            if(i == n-1){
                if(map.getOrDefault(i, 0) != 2){
                    return false;
                }
            }else {
                if(map.getOrDefault(i, 0) != 1){
                    return false;
                }
            }
        }
        return true;
    }
}