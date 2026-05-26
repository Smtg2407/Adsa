class Solution {
    public int minAddToMakeValid(String s) {
        
        int balance = 0;
        int unMatched = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                balance++;
            }
            else if(ch == ')'){
                balance--;

                if(balance < 0){
                    unMatched++;
                    balance = 0;
                }
            }
        }
        return balance + unMatched;


        
    }
}