class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = 0, r = s1.length() - 1;
        HashMap<Character, Integer> charMap = new HashMap<>();
        HashMap<Character, Integer> s1Map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++)
        {
            char c = s1.charAt(r);
            if(s1Map.get(c) == null)
                s1Map.put(c, 1);
            else
            {
                s1Map.put(c, s1Map.get(c) + 1);
            }
        }

        for(; r < s2.length(); l++, r++)
        {
            char c = s2.charAt(r);
            if(charMap.get(c) == null)
                charMap.put(c, 1);
            else
            {
                charMap.put(c, charMap.get(c) + 1);
            }

            char c2 = s2.charAt(l);
            charMap.put(c2, charMap.get(c2) - 1);
        }

        return false;
    }
}
