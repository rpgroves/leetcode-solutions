class Solution {
    public int lengthOfLongestSubstring(String s) {
        //given a string of characters
        //return the longest string that has no duplicate characters 
        //(xyzx does not work for instance)

        //First thought for a solution
        //iterate from left to right, placing characters found into a map
        //when a character has already been placed in the map, we know weve found a repeat character
        //this wouldnt account for things like 12345617890

        //We can use the sliding window algorithm. We will have indices l and r,
        //we will move r forward with each iteration.
        //when there is a duplicate we will move l forward.

        int l = 0, maxSubstring = 0;
        boolean duplicatePresent = false;
        HashMap<Character, Integer> letterMap = new HashMap<Character, Integer>();

        for(int r = 0; r < s.length(); r++)
        {
            if(letterMap.get(s.charAt(r)) == null)
                letterMap.put(s.charAt(r), 1);
            else
                letterMap.put(s.charAt(r), letterMap.get(s.charAt(r)) + 1);

            while(letterMap.get(s.charAt(r)) > 1)
            {
                letterMap.put(s.charAt(l), letterMap.get(s.charAt(l)) - 1);
                l++;
            }

            if(r - l + 1 > maxSubstring)
                maxSubstring = r - l + 1;
        }

        return maxSubstring;
    }
}
