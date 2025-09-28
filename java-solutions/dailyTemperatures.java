class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];

        int high = -1;
        for(int i = 0; i < temperatures.length; i++)
        {
            int temp = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] < temp)
            {
                ret[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        return ret;
    }
}
