class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for(int mid = 0; mid <s.length(); mid++){
            int lenOdd = expandFromCenter(s, mid, mid);

            int lenEven = expandFromCenter(s, mid , mid + 1);

            int maxLen = Math.max(lenOdd, lenEven);

            if(maxLen > end - start) {
                start = mid - (maxLen - 1) / 2;
                end = mid + maxLen / 2;
            }
            
        } 
        return s.substring(start, end + 1);       
    }
    public int expandFromCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}