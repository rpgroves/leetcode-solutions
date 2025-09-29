class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = -1;

        for(int i = 0; i < heights.length; i++)
        {
            int height = heights[i];
            if(stack.isEmpty())
            {
                stack.push(i);
                continue;
            }
            if(height < stack.peek())
                stack.push(i);
            if(height >= stack.peek())
            {
                int pop = stack.pop();
                int area = i - pop * heights[pop];
                if(area > max)
                    max = area;
                stack.push(i);
            }
        }
        return max;
    }
}
