class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
            {
                stack.push(c);
            }
            else
            {
                if(!stack.empty() && (c == stack.peek() + 2 || c == stack.peek() + 1))
                    stack.pop();
                else
                    return false;
            }
        }
        if(!stack.empty())
            return false;

        return true;
    }
}
