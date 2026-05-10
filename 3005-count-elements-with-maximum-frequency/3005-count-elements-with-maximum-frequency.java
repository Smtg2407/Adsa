class Solution {
    public int maxFrequencyElements(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int maxFreq = 0;

        for(Integer freq : map.values()){
            if(freq > maxFreq){
                maxFreq = freq;
            }
        }
        int count = 0;

        for(Integer freq : map.values()){

            if(freq == maxFreq){

                count += freq;
            }
        }
        return count;
    }
}