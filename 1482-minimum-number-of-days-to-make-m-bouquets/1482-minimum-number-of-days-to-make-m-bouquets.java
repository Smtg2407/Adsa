class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        long total = (long) m * k;
        if(total > bloomDay.length){
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i = 0; i < bloomDay.length; i++){
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canMake(bloomDay, mid, m, k)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean canMake(int[] bloomDay, int day, int m, int k){
        int count = 0;
        int bouquets = 0;

        for(int i = 0; i< bloomDay.length; i++){
            if(bloomDay[i] <= day){
                count++;

                if(count == k){
                    bouquets++;
                    count = 0;
                }
            }else{
                count = 0;
            } 
            if(bouquets >= m){
                return true;
            }  
        }
        return false;
    }
}