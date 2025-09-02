class Solution {
    public String encode(List<String> strs) {
        String output = "";
        for(String s : strs)
        {
            output += "#";
            output += s.length();
            output += s;
        }
        return output;
    }

    public List<String> decode(String str) {
        ArrayList<String> strs = new ArrayList<>();
        //System.out.println(str);

        int letterCount = 0;
        String currentWord = "";
        for(int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            //System.out.println(c);
            if(c == '#' && currentWord != "")
            {
                //System.out.println("test 1");
                strs.add(currentWord);
                currentWord = "";
            }
            else if (c >= '0' && c <= '9')
            {
                //System.out.println("test 2");
                letterCount = c;
            }
            else if(c != '#')
            {
                //System.out.println("test 3");
                currentWord += c;
            }
        }
        if(currentWord != "")
            strs.add(currentWord);
        return strs;
    }
}
