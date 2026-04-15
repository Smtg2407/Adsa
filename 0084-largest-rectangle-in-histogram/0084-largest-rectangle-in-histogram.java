class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        for(int i = 0; i <= n; i++){
            int currHeight;
            if(i == n){
                currHeight = 0;
            }else{
                currHeight = heights[i];

            }
            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){
                int h = heights[stack.pop()];
                int right = i;
                int left;

                if(stack.isEmpty()){
                    left = -1;
                }else{
                    left = stack.peek();
                }
                int width = right - left - 1;
                int area = h * width;

                if(area > maxArea){
                    maxArea = area;
                }
            }
            stack.push(i);

        } 
        return maxArea;
    }
}