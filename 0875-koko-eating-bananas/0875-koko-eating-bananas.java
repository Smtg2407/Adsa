class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxPiles = 0;

        for(int i = 0; i < piles.length; i++){
            if(piles[i] > maxPiles){
                maxPiles = piles[i];
            }
        }
        int low = 1;
        int high = maxPiles;
        int ans = maxPiles;

        while(low <= high){
            int mid = low + (high - low) /2;
            long totalHours = getHours(piles, mid);

            if(totalHours <= h){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
        
    }
    public long getHours(int[] piles, int speed){
        long time = 0;

        for(int i = 0; i < piles.length; i++){
            time += (piles[i] + speed - 1) / speed;
        }
        return time;
    }
}