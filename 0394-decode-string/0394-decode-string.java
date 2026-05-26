class Solution {
    public String decodeString(String s) {

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch != ']'){
                st.push(ch);
            }
            else{
                StringBuilder temp = new StringBuilder();

                while(!st.isEmpty() && st.peek() != '['){
                    temp.append(st.pop());
                }
                temp.reverse();
                st.pop();

                StringBuilder num = new StringBuilder();

                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    num.insert(0, st.pop());
                }

                int number = Integer.parseInt(num.toString());
                StringBuilder repeat = new StringBuilder();

                for(int j = 0; j < number; j++){
                    repeat.append(temp);
                }

                for(char c : repeat.toString().toCharArray()){
                    st.push(c);
                }
            }
        }
        StringBuilder ans = new StringBuilder();

        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();
        return ans.toString();

        
        
    }
}