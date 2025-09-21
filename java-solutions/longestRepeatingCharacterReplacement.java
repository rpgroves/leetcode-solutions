class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, max = 0;
        HashMap<Character, Integer> letterMap = new HashMap<>();

        for(; r < s.length(); r++)
        {
            char c = s.charAt(r);
            if(letterMap.get(c) == null)
            {
                letterMap.put(c, 1);
            }
            else
            {
                letterMap.put(c, letterMap.get(c) + 1);
            }

            while((r - l + 1) - Collections.max(letterMap.values()) - k > 0 && l + 1 <= r)
            {
                letterMap.put(s.charAt(l), letterMap.get(s.charAt(l)) - 1);
                l++;
            }

            if(r - l + 1 > max)
                max = r - l + 1;

            System.out.println(l + " " + r + " " + max);
        }

        return max;
    }
}
