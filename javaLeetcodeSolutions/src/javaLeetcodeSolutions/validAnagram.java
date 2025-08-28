package javaLeetcodeSolutions;

import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if(sMap.get(sc) == null)
                sMap.put(sc, 1);
            else
                sMap.put(sc, sMap.get(sc) + 1);
            if(tMap.get(tc) == null)
                tMap.put(tc, 1);
            else
                tMap.put(tc, tMap.get(tc) + 1);
        }
        
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (!sMap.get(c).equals(tMap.get(c)))                  
                return false;
        }

        return true;
    }
}
