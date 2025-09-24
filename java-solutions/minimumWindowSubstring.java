class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        String shortest = "";

        for(int i = 0; i < t.length(); i++)
        {
            char c = t.charAt(i);
            if(tMap.get(c) == null)
                tMap.put(c, 1);
            else
                tMap.put(c, tMap.get(c) + 1);
        }

        int have = 0, need = tMap.size();

        int l = 0, r = 0;
        for(; r < s.length(); r++)
        {
            char c = s.charAt(r);
            if(window.get(c) == null)
                window.put(c, 1);
            else
                window.put(c, window.get(c) + 1);

            if(tMap.get(c) != null && window.get(c) == tMap.get(c))
                have++;

            while(have == need && l < s.length())
            {
                char c2 = s.charAt(l);
                window.put(c2, window.get(c2) - 1);
                if(r - l < shortest.length() || shortest == "")
                    shortest = s.substring(l, r + 1);
                if(tMap.get(c2) != null && window.get(c2) < tMap.get(c2))
                    have--;
                l++;
            }

        }

        return shortest;
    }
}
