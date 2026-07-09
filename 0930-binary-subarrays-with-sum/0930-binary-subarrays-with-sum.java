class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for(int n : nums){
            currentSum += n;

            if(map.containsKey(currentSum - goal)) {
                count += map.get(currentSum - goal);
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}