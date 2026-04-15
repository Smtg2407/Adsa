class Solution {
    public int[] countBits(int n) {

        int result[] = new int[n + 1];

        for(int i = 0; i <= n ;i++){
            result[i] = countOnes(i);
        }
        return result;
    }
    public int countOnes(int num){
        int count= 0;

        while(num > 0){
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}