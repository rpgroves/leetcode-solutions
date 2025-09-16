class Solution {
    public boolean isPalindrome(String s) {
        int x = 0, y = s.length() - 1;

        for(; x < s.length(); x++)
        {
            while(x < s.length() && !Character.isLetterOrDigit(s.charAt(x)))
                x++;
            while(y >= 0 && !Character.isLetterOrDigit(s.charAt(y)))
                y--;

            if(x >= s.length())
            {
                while(y > 0)
                {
                    if(Character.isLetterOrDigit(s.charAt(y)))
                        return false;
                    y--;
                }
                break;
            }
            if(y < 0)
            {
                while(x < s.length())
                {
                    if(Character.isLetterOrDigit(s.charAt(x)))
                        return false;
                    x++;
                }
                break;
            }

            System.out.println(x + " " + s.charAt(x) + " " + y + " " + s.charAt(y));
            if(Character.toLowerCase(s.charAt(x)) != Character.toLowerCase(s.charAt(y)))
                return false;
            y--;
        }

        return true;
    }
}
