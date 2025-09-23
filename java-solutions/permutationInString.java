class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = 0, r = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        HashMap<Character, Integer> s1Map = new HashMap<>();

        //populate the s1Map
        for(int i = 0; i < s1.length(); i++)
        {
            char c = s1.charAt(i);
            if(s1Map.get(c) == null)
                s1Map.put(c, 1);
            else
            {
                s1Map.put(c, s1Map.get(c) + 1);
            }
        }

        //slide a window through s2
        for(; r < s2.length(); r++)
        {
            char c = s2.charAt(r);
            if(charMap.get(c) == null)
                charMap.put(c, 1);
            else
            {
                charMap.put(c, charMap.get(c) + 1);
            }

            char c2 = s2.charAt(l);
            if(r - l > s1.length() - 1)
            {
                charMap.put(c2, charMap.get(c2) - 1);
                l++;
            }
            c2 = s2.charAt(l);

            boolean matchingSet = true;
            for(int i = 0; i < s1.length(); i++)
            {
                char ci = s1.charAt(i);
                if(!(charMap.get(ci) == s1Map.get(ci)))
                {
                    matchingSet = false;
                }
            }

            if(matchingSet)
                return true;
        }

        return false;
    }
}
