class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int currSum = 0;

        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];

            if(currSum == k) count++;

            if(map.containsKey(currSum - k)){
                count += map.get(currSum - k);
            }

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        }
        return count;
    }
}