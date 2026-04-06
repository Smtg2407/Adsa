class Solution {
    public int climbStairs(int n) {

        if(n <= 2) return n;


        int first = 2;
        int second = 1;

        for(int i = 3; i <= n; i++){
            int curr = first + second;

            second = first;
            first = curr;
        }
        return first;

    
        
    }
}