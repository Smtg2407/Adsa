class Solution {
    public int pivotIndex(int[] nums) {
        int leftPre[] = new int[nums.length];
        int rightPre[] = new int[nums.length];

        int i = 1;
        leftPre[0] = nums[0];
        rightPre[nums.length - 1] = nums[nums.length - 1];

        int j = nums.length - 2;

        while(i < nums.length && j >= 0){
            leftPre[i] = leftPre[i - 1] + nums[i];
            rightPre[j] = rightPre[j + 1] + nums[j];
            i++;
            j--;     

        }
        for(int k = 0; k < nums.length; k++){
            if(leftPre[k] == rightPre[k]){
                return k;
            }
        }
        return -1;
    }
}