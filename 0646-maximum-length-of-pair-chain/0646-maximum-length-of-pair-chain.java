class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int ans = 0;
        int prevEnd = Integer.MIN_VALUE;

        for(int i = 0; i < pairs.length; i++){
            int[] pair = pairs[i];

            if(pair[0] > prevEnd){
                ans++;

                prevEnd = pair[1];
            }
        }
        return ans;
    }
}