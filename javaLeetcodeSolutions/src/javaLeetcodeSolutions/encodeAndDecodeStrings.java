class Solution {
    public String encode(List<String> strs) {
        if(strs.isEmpty())
            return null;
        String output = "";

        if(strs.size() < 100)
            output += "0";
        if(strs.size() < 10)
            output += "0";
        output += strs.size();
        output += "#";

        for(String s : strs)
        {
            output += s.length();
            output += "#";
            output += s;
        }
        return output;
    }

    public List<String> decode(String str) {
        ArrayList<String> strs = new ArrayList<>();
        System.out.println(str);

        if(str == null)
            return strs;

        String wordCountStr = "";
        int wordCount = 0;
        for(int i = 0; i < 3; i++)
        {
            wordCountStr += str.charAt(i);
        }
        wordCount = Integer.parseInt(wordCountStr);
        str = str.substring(4);
        System.out.println(str);

        int index = 0;
        for(int i = 0; i < wordCount; i++)
        {
            String letterCountStr = "";
            int letterCount = 0;
            while(Character.isDigit(str.charAt(index)))
            {
                letterCountStr += str.charAt(index);
                index++;
            }
            index++;
            letterCount = Integer.parseInt(letterCountStr);
            String currentWord = "";
            for(int j = 0; j < letterCount; j++)
            {
                currentWord += str.charAt(index);
                index++;
            }
            strs.add(currentWord);
        }
        
        return strs;
    }
}
