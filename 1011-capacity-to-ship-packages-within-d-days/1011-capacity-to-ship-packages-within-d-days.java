class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int n = weights.length;
        int low = 0;
        int high = 0;

        for(int i = 0; i< n; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        while(low < high) {
            
            int mid = low + (high - low)/2;
            int need = 1;
            int load = 0;

            for(int i = 0; i < n; i++){
                if(load + weights[i] > mid) {
                    need++;
                    load = 0;
                }
                load += weights[i];
            }
            if(need <= days){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}