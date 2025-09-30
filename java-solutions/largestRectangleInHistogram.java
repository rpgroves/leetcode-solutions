class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = -1;

        for(int i = 0; i <= heights.length; i++)
        {
            int height = -1;
            if(i != heights.length)
                height = heights[i];
            else height = 0;
            if(height > max)
                max = height;
            if(i != heights.length && stack.isEmpty())
            {
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && height < heights[stack.peek()])
            {
                int pop = stack.pop();
                int area = -1;
                if(stack.isEmpty())
                    area = (i) * heights[pop];
                else
                    area = (i - stack.peek() - 1) * heights[pop];
                if(area > max)
                    max = area;
                
            }
            stack.push(i);
        }
        return max;
    }
}
