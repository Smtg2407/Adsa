class Solution {
    public int minRemovals(int[] nums, int target) {
        int n = nums.length;

        int totalXor = 0;

        for(int i = 0;i<n;i++){
            totalXor ^= nums[i];
        }
        if(totalXor ==target) return 0;

        int need = totalXor ^ target;

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0,0);

        for(int i = 0; i <n ;i++){
            int num = nums[i];
            Map<Integer, Integer> next = new HashMap<>(dp);

            for(Map.Entry<Integer, Integer> entry : dp.entrySet()){
                int newXor = entry.getKey() ^ num;
                int cnt = entry.getValue() + 1;

                if(!next.containsKey(newXor)) {
                    next.put(newXor,cnt);
                    
                }else{
                    next.put(newXor, Math.min(next.get(newXor),cnt));
                }
            }
            dp = next;
        }
        if(!dp.containsKey(need)) return -1;

        return dp.get(need);
    }
}