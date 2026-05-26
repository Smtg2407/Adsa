class Solution {
    public int calPoints(String[] operations) {
        
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < operations.length; i++){

            String oper = operations[i];

            if(oper.equals("C")){
                stack.pop();
            }
            else if(oper.equals("D")){
                stack.push(2* stack.peek());
            }
            else if(oper.equals("+")){
                int top = stack.pop();
                int newScore = top + stack.peek();

                stack.push(top);
                stack.push(newScore);
            }
            else {
                stack.push(Integer.parseInt(oper));
            }
        }
        int sum = 0;

        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}