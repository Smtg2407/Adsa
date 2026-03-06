class Solution {
    public long maxAlternatingSum(int[] nums) {
        long even = 0;
        long odd = 0;

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];

            long newEven = Math.max(even, odd + num);
            long newOdd = Math.max(odd, even - num);

            even = newEven;
            odd = newOdd;
        }
        return even;

    }
}